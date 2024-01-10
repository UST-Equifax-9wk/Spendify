import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RemoteService {
  http: HttpClient;
  baseUrl="http://localhost:8080"
  constructor(client: HttpClient) { 
    this.http=client;
  }

  registerUser(account:UserAccountDto){
    return this.http.post(this.baseUrl+"/create-account/user",JSON.stringify(account),
    {observe:'response',
    withCredentials:true,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })})
  }

  postNewProduct(accountName : string, productDto : ProductDto) {
    return this.http.post(this.baseUrl+`/${accountName}/products`,JSON.stringify(productDto),
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    })
  }
  
  getListOfProducts(category: string): Observable<any> {
    return this.http.get(this.baseUrl + `/${category}/products`,
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

}


export interface User{
  firstName:string;
  lastName:string;
  email:string;
  address:string;
}

export interface UserAccountDto{
  user:User;
  accountName:string;
  password:string;
}

export interface ProductDto{
  productName : string
  price : number
  category : string
  weight : number
  stock : number
  discount : number
  description : string
  // Added these two lists recently
  reviewList: number[]
  cartLookupList: number[]
  // To allow collapsible attributes
  showMore:boolean 
}

export enum Category{
  TECH,
  PETS,
  CLEANING,
  KITCHEN
}