import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class DistributorServiceService {
  httpClient: HttpClient;
  baseUrl: string;
  httpOptions = {
    observe: 'response',
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
    this.baseUrl = 'http://localhost:8080';
   }

    registerDistributor(newDistributor: NewDistributorDto): Observable<HttpResponse<Object>> {
      return this.httpClient.post(this.baseUrl + '/create-account/distributor', newDistributor,{
        observe: 'response',
        withCredentials: true,
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      });
    }
}

export interface NewDistributorDto{
  distributor: DistributorDto;
  password: string;
  accountName: string;
}

export interface DistributorDto{
  name: string;
  email: string;
}
