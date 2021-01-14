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

    getCofirmedDeliveryInfo(id): Observable<any> {
        const url = this.serverUrl + 'deliveryinfo?id=' + id;
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

    getFactors(): Observable<any> {
        const url = this.serverUrl + 'timefactors';
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

    getDeliveryServices(): Observable<any> {
        const url = this.serverUrl + 'deliveryservices';
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

    getAdjustCost(context: any): Observable<any> {
        const url = this.serverUrl + 'adjustcost';
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

    confirmBuying(context): Observable<any> {
        const url = this.serverUrl + 'confirm';
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
