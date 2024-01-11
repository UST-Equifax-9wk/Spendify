import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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

  login(accountName : string, password : string) {
    return this.http.post(this.baseUrl+`/login`,JSON.stringify({ accountName, password }),
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    })
  }
  postNewReview(reviewDto : ReviewDto, productId : number) {
    return this.http.post(this.baseUrl+`/products/${productId}/reviews`,JSON.stringify(reviewDto),
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
        'Content-Type' : 'application/json'
      })
    })
  }

  getListOfReviews(id:number): Observable<any> {
    return this.http.get(this.baseUrl + `/products/${id}/reviews`,
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
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
  productId?:number
  productName : string
  price : number
  category : string
  weight : number
  stock : number
  discount : number
  description : string
  reviewList: ReviewDto[]
  cartLookupList: number[]
  showMore:boolean 
}

export interface ReviewDto{
  // Changed from "text"
  reviewText : string
  rating : number
  accountName : string
}

export enum Category{
  TECH,
  PETS,
  CLEANING,
  KITCHEN
}