import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Users } from './users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  baseurl = 'http://localhost:4200/users/';
  
  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  CreateUser(data: any): Observable<Users> {
    return this.http.post<Users>(this.baseurl , JSON.stringify(data), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }  

    // GET by id
    GetUserbyId(id: number): Observable<Users> {
      return this.http.get<Users>(this.baseurl + id)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
    }

     // GET ALL
  GetUser(): Observable<Users> {
    return this.http.get<Users>(this.baseurl)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }
 // DELETE by id 
 DeleteUser(id: number){
  return this.http.delete<Users>(this.baseurl + id, this.httpOptions)
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
