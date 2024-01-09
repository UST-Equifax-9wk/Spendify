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

  registerUser(account:UserAccountDto){
    return this.http.post(this.baseUrl+"/create-account/user",JSON.stringify(account),
    {observe:'response',
    withCredentials:true,
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })})
  }
}

export interface User{
  firstName:String;
  lastName:String;
  email:String;
  address:String;
}

export interface UserAccountDto{
  user:User;
  accountName:String;
  password:String;
}
