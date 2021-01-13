import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})

export class BuyService {

    serverUrl: string = 'http://localhost:8089/';

    options = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        }),
    };

    constructor(private http: HttpClient) {}

    getDeliveryServices(): Observable<any> {
        const url = this.serverUrl + 'getDeliveryServices';
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

    confirmBuying(context): Observable<any> {
        const url = 'confirm';
        return this.http.post<any>(url, context, this.options).pipe(
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
