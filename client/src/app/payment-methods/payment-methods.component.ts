import { Component } from '@angular/core';
import { Card, RemoteService } from '../remote.service';
import { CurrentAccountService } from '../current-account.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-payment-methods',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payment-methods.component.html',
  styleUrl: './payment-methods.component.css'
})
export class PaymentMethodsComponent {
  remote:RemoteService;
  current:CurrentAccountService;
  cards:Array<Card>=[];
  cardNumber="";
  cardName="";
  cardExpiration="";
  constructor(remote:RemoteService, current:CurrentAccountService){
    this.remote=remote;
    this.current=current;
    if(this.current.accountName!=''){
      this.remote.getCards(this.current.accountName).subscribe({
        next:(data)=>{
          this.cards= data.body as Array<Card>;
        },
        error:(error:HttpErrorResponse)=>{
          console.log(error);
        }
      })
    }
  }

  addCard(){
    if(this.cardName==""||this.cardNumber==""||this.cardExpiration==""){
      alert("Denied: Please fill out all fields")
      return;
    }
    if(this.cardNumber.length<4){
      alert("Denied: Card Number too short")
      return
    }
    if(this.current.getUserAccount().user.firstName==""){
      alert("Error: No current user")
      return
    }
    let card:Card={
      name: this.cardName,
      cardNumber: this.cardNumber,
      expirationDate: this.cardExpiration,
      user: this.current.getUserAccount().user
    }
    this.remote.addCard(card,this.current.accountName).subscribe({
      next:(data)=>{
        this.cards.push(data.body as Card)
        this.cardName="";
        this.cardExpiration="";
        this.cardNumber="";
      },
      error:(error:HttpErrorResponse)=>{
        alert("Error submitting card")
        console.log(error)
      }
    })
  }

  

  
}
