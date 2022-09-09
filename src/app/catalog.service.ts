import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Catalog } from './catalog';
@Injectable({
  providedIn: 'root'
})
export class CatalogService {


}
