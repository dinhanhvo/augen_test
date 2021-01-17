package com.augen.augen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.augen.augen.response.ApiResp;
import com.augen.layer.services.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<ApiResp> getBooks(@RequestParam String q) {
        ApiResp apiResp = new ApiResp();
        String books = BookService.getBooks(q); // use fake BookService
        apiResp.setData(books);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
