import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Users } from './user';
import { CreateUsers } from './createUser';

@Injectable({
  providedIn: 'root'
})

export class UsersService {
  baseurl = 'http://localhost:8080/shoppingusers/';

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  
  //POST User
  CreateUser(data: CreateUsers): Observable<CreateUsers> {
    console.log("MADE INTO USERS CREATE ")
    console.log(data)
    return this.http.post<CreateUsers>(this.baseurl, data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )


  }

  // CreateUser(data: any): Observable<HttpResponse<Object>>
  // {
  //   console.log("initiating POST request...")
  //   let observable: Observable<HttpResponse<Object>> = this.http.post(
  //     this.baseurl + '/auth',
  //     JSON.stringify(param),
  //     {
  //       observe: 'response',
  //       headers: new HttpHeaders(
  //         {
  //           'Content-Type': 'application/json'
  //         })
  //     }).pipe(retry(1), catchError(this.errorHandl));

  //   return observable;
  // }

  getIdFromLocalStorage(){
    return window.localStorage.getItem("currentUserId")
  }

  // GET by id
  GetUserbyId(): Observable<Users> {
    let currentUserId = Number(localStorage.getItem("currentUserId"));
    return this.http.get<Users>(this.baseurl + currentUserId)
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

//Update User Info
UpdateUser(data: Users): Observable<Users> {
  console.log("Update User Info")
  return this.http.put<Users>(this.baseurl , data, this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.errorHandl),
  )
}

  // DELETE by id 
  DeleteUser(id: number) {
    return this.http.delete<Users>(this.baseurl + id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
  }
  // error handling
  errorHandl(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
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
