import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Purchases } from './purchases';

@Injectable({
  providedIn: 'root'
})
export class PurchasesService {
  baseurl = 'http://localhost:4200/purchases/';
  
  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  CreatePurchase(data: any): Observable<Purchases> {
    return this.http.post<Purchases>(this.baseurl , JSON.stringify(data), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }  

    // GET by id
    GetPurchasebyId(purchaseId: number): Observable<Purchases> {
      return this.http.get<Purchases>(this.baseurl + purchaseId)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
    }

     // GET ALL
  GetPurchases(): Observable<Purchases> {
    return this.http.get<Purchases>(this.baseurl)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }
 // DELETE by id 
 DeletePurchase(purchaseId: number){
  return this.http.delete<Purchases>(this.baseurl + purchaseId, this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.errorHandl)
  )
}
// error handling
errorHandl(error: any) {
  let errorMessage = '';
  if(error.error instanceof ErrorEvent) {
    // Get client-side error
    errorMessage = error.error.message;
  } else {
    // Get server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  console.log(errorMessage);
  return throwError(errorMessage);
}
  
}
