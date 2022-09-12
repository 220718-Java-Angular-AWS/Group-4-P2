import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Users } from './user';
import { Login } from './login';


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
  Login1(login: Login): Observable<Users> {
    return this.http.get<Users>(this.baseurl + login)
    let loginattempt : Observable<Users> = this.http.post<Users>(this.baseurl, JSON.stringify(login), this.httpOptions).pipe(retry(1), catchError(this.errorHandl))
    loginattempt.subscribe((event) => {console.log(event)})
    console.log("Login Attempt:" + loginattempt)
    return loginattempt
    
  }

  Login2(Users: any){
  return this.http.post<Users>(this.baseurl, Users, this.httpOptions)

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