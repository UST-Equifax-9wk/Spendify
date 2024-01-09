import { Injectable } from '@angular/core';
import { User } from './remote.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  firstName: string;
  lastName: string;
  email: string;
  address: string;


  constructor() { 
    this.firstName = "";
    this.lastName = "";
    this.email = "";
    this.address = "";
  }

  getFirstName(): String {
    return this.firstName;
  }

  setCurrentUser(user: User) {
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.email = user.email;
    this.address = user.address;
  }

  getCurrentUser():User {
    let user:User = {
      firstName: this.firstName,
      lastName: this.lastName, 
      email: this.email,
      address: this.address
    }
    return user;
  }
}
