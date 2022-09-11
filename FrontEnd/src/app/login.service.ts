import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Login } from './login';
import { Users } from './users';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseurl = 'http://localhost:8080/login/';
  
  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  Login1(username: String, password: any): Observable<Users> {
    let loginattempt : Observable<Users> = this.http.post<Users>(this.baseurl, JSON.stringify(username, password), this.httpOptions).pipe(retry(1), catchError(this.errorHandl))
    loginattempt.subscribe((event) => {console.log(event)})
    return loginattempt
  }

  Login2(Users: any){
  return this.http.post<Users>(this.baseurl, Users)

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
