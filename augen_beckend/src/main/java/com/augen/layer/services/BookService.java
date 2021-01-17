package com.augen.layer.services;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.augen.constant.ApiConstant;

/*
 * Create this class to get data from Google'api
 */
public class BookService {

    // Creating a HttpClient object
    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    //Executing the Get request
    static HttpResponse httpresponse;
    
    public static String getBooks(String searchText) {
        
        // Creating a HttpGet object
        HttpGet httpget = new HttpGet(ApiConstant.GET_BOOKS + searchText);
        
        // Printing the method used
        System.out.println("Request Type: "+httpget.getMethod());
        
        // get data from google  and forward to front-end
        StringBuffer sb = new StringBuffer();
        Scanner sc = null;
        try {
            httpresponse = httpclient.execute(httpget);
            sc = new Scanner(httpresponse.getEntity().getContent());
            System.out.println(httpresponse.getStatusLine());
            
            while(sc.hasNext()) {
               sb.append(sc.nextLine());
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return sb.toString();
    }
}
