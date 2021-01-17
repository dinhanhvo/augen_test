import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})

export class BookService {

    serverUrl: string = 'http://localhost:8089/';

    options = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        }),
    };

    constructor(private http: HttpClient) {}

    getBooks(text: string): Observable<any> {
        const url = this.serverUrl + 'books?q=' + text;
        return this.http.get<any>(url, this.options).pipe(
            tap(
                data => {
                    // console.log(data);
                },
                error => {
                    console.log('book-service: error', error);
                }
            )
        );
    }

    getBook(id: string): Observable<any> {
        const url = 'book?id=' + id;
        return this.http.get<any>(url, this.options).pipe(
            tap(
                data => {
                    // console.log(data);
                },
                error => {
                    console.log('book-service: error', error);
                }
            )
        );
    }
}
