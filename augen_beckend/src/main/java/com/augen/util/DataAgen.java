package com.augen.util;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.augen.augen.response.ApiResp;

public class DataAgen {

    // Creating a HttpClient object
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    //Creating a HttpGet object
    private HttpGet httpget = null; // 
    
    private String url;

    //Executing the Get request
    HttpResponse httpresponse;
    
    public DataAgen(String url) {
        this.httpget = new HttpGet(url);
    };
    
    public ApiResp getData() {
        ApiResp apiResp = new ApiResp();
        //Printing the method used
        System.out.println("Request Type: "+httpget.getMethod());
        Scanner sc = null;
        try {
            httpresponse = httpclient.execute(httpget);
            sc = new Scanner(httpresponse.getEntity().getContent());
            System.out.println(httpresponse.getStatusLine());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
               sb.append(sc.nextLine());
            }
            apiResp.setData(sb);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            apiResp.setErrors("Can not get data");
        } finally {
            sc.close();
        }
        return apiResp;
    }
}
