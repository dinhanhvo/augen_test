import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})

export class BookService {

    options = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        }),
    };

    constructor(private http: HttpClient) {}

    getBooks(): Observable<any> {
        const url = 'http://localhost:8080/books';
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
