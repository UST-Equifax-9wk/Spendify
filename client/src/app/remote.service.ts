import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RemoteService {
  http: HttpClient;
  baseUrl="http://localhost:8080"
  constructor(client: HttpClient) { 
    this.http=client;
  }

  registerUser(account:AccountDto){
    this.http.post(this.baseUrl+"/create-account/user",JSON.stringify(account),
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
}


export interface User{
  firstName:String;
  lastName:String;
  email:String;
  address:String;
}

export interface AccountDto{
  user:User;
  accountName:String;
  password:String;
}

export interface ProductDto{
  productName : string
  price : number
  category : string
  weight : number
  stock : number
  discount : number
  description : string
}

export enum Category{
  TECH,
  PETS,
  CLEANING,
  KITCHEN
}