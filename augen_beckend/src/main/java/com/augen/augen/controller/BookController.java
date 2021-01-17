package com.augen.augen.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.augen.augen.model.BuyBookModel;
import com.augen.augen.response.ApiResp;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<ApiResp> getBooks(@RequestParam String q) {
        ApiResp apiResp = new ApiResp();
        //Creating a HttpClient object
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String searchText = (q == null || q.trim().length() == 0)? "%7bsearch": q;
        System.out.println("BookController.getBooks()====== searchText=" + searchText);
        //Creating a HttpGet object
        HttpGet httpget = new HttpGet("https://www.googleapis.com/books/v1/volumes?q=" + searchText);

        //Printing the method used
        System.out.println("Request Type: "+httpget.getMethod());

        //Executing the Get request
        HttpResponse httpresponse;
        try {
            httpresponse = httpclient.execute(httpget);
            Scanner sc = new Scanner(httpresponse.getEntity().getContent());
            System.out.println(httpresponse.getStatusLine());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
               sb.append(sc.nextLine());
            }
            apiResp.setData(sb);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
