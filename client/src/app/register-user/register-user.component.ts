import { Component } from '@angular/core';
import { RemoteService, User, UserAccountDto } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register-user.component.html',
  styleUrl: './register-user.component.css'
})
export class RegisterUserComponent {
  remote:RemoteService;
  firstName="";
  lastName="";
  email="";
  address="";
  accountName="";
  password="";
  confirmPassword="";
  invalidPassword=true;
  invalidEmail=true;
  invalidAccountName=true;
  clicked=false;
  constructor(remoteService:RemoteService){
    this.remote=remoteService;
    console.log("bark")
  }

  register(){
    this.clicked=true;
    if(this.password.length>=8)this.invalidPassword=false;
    else this.invalidPassword=true;
    if(this.email.includes("@")&&this.email.includes("."))this.invalidEmail=false;
    else this.invalidEmail=true;
    if(this.accountName.length>=4)this.invalidAccountName=false;
    else this.invalidAccountName=true;

    if(this.invalidAccountName||
      this.invalidEmail||
      this.invalidPassword||
      this.firstName==""||
      this.lastName==""||
      this.address==""||
      this.password!=this.confirmPassword
      ){
        alert("Invalid Submission");
        return;
    }
    else{
      let user:User={
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        address: this.address
      }
      let dto:UserAccountDto={
        user: user,
        accountName: this.accountName,
        password: this.password
      }
      this.remote.registerUser(dto).subscribe({
        next:(data)=>{
          alert("WAIT FOR CURRENT USER SERVICE")
        },
        error:(error:HttpErrorResponse)=>{
          if(error.status==400) alert("Denied: Invalid Input");
          else if (error.status==409) alert("Denied: Username or email already in use");
          else if (error.status==417) alert("Denied: Error Communicating With Server")
          else alert("Denied: Unknown Error");
          
        }
      })
    }
  }
}
