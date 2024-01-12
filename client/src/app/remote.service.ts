import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DistributorDto } from './distributor.service';

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

  getAccount(username : string): Observable<HttpResponse<Object>> {
    return this.http.get(this.baseUrl+"/retrieve-account/" + username,{
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    })
  }

  updateProduct(productDto : ProductDto) {
    return this.http.put(this.baseUrl+`/product`,JSON.stringify(productDto),
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
  getCart(name:string){
    return this.http.get(this.baseUrl+"/"+name+"/cart",
    {observe:'response',
    withCredentials:true,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}
    )
  }
  
  editCart(name:string,lookup:CartLookup){
    return this.http.post(this.baseUrl+"/"+name+"/cart/edit",JSON.stringify(lookup),
    {observe:'response',
    withCredentials:true,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}
    )
  }

  postBid(productId : number, bidDto : BidDto) {
    return this.http.post(this.baseUrl + `/products/${productId}/bid`, JSON.stringify(bidDto),
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    })
  }

  addCard(card:Card, name:string){
    return this.http.post(this.baseUrl+"/card/"+name,JSON.stringify(card),
    {observe:'response',
    withCredentials:true,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}
    )
  }

  getCards(accountName:string){
    return this.http.get(this.baseUrl+"/card/"+accountName,
    {observe:'response',
    withCredentials:true,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}
    )
  }
}


export interface CartWithProducts{
  cart:Cart;
  productList:Array<CartLookup>;
}
export interface CartLookup{
  cartLookUpId:number;
  quantity:number;
  product:ProductDto;
}
export interface Cart{
  cartId:number;
  active:boolean;
  order:Order;
}
export interface Order{

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

export interface BidDto{
  accountName : string
  bid : number
}

export interface ProductDto{
  isEditing?: boolean;
  productId? : number
  productName : string
  price : number
  category : string
  weight : number
  stock : number
  discount : number
  description : string
  threshold : number
  biddable : boolean
  currentBid : number
  // Added these two lists recently
  //reviewList?: number[]
  //cartLookupList?: number[]
  reviewList: ReviewDto[]
  cartLookupList: number[]
  // To allow collapsible attributes
  showMore?:boolean 
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

export interface Account{
  accountId:number,
  accountName:string,
  distributorFlag:boolean,
  user:User,
  distributor:DistributorDto,
  cartList:Array<Cart>,
  productList:Array<ProductDto>,
  orderList:Array<Order>
}
export interface Card{
  cardId?:number,
  name:string,
  cardNumber:string,
  expirationDate:string,
  user:User
}
