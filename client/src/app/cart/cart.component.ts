import { Component } from '@angular/core';
import { CartLookup, CartWithProducts, ProductDto, RemoteService } from '../remote.service';
import { CurrentAccountService } from '../current-account.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {
  remote:RemoteService;
  currentCart:CartWithProducts={
    cart: {
      cartId: 0,
      active: false,
      order: {}
    },
    productList: []
  };
  currentAccount:CurrentAccountService;
  constructor(remote:RemoteService, currentAccount:CurrentAccountService){
    this.remote=remote;
    this.currentAccount=currentAccount;
    remote.getCart(currentAccount.accountName).subscribe({
      next:(data)=>{
        this.currentCart=data.body as CartWithProducts;
        console.log("set")
        console.log(this.currentCart)
      },
      error:(error:HttpErrorResponse)=>{
        console.log(error)
      }
    });
  }
  removeProduct(lookup:CartLookup){
    this.editProduct(lookup,0);
  }
  changeQuantity(lookup:CartLookup){
    let quantity = window.prompt("Enter a quantity");
    if(quantity == ""||quantity==null){
      alert("Cancelled, no quantity entered");
      return;
    }
    //tests true if non numberic characters are entered
    if(/\D/.test(quantity)){
      alert("Cancelled, invalid quantity entered");
      return;
    }
    let q = parseInt(quantity);
    this.editProduct(lookup,q);
  }
  editProduct(lookup:CartLookup,quantity:number){
    lookup.quantity=quantity;
    this.remote.editCart(this.currentAccount.accountName,lookup).subscribe({
      next:(data)=>{
        this.currentCart=data.body as CartWithProducts;
        console.log("set")
        console.log(this.currentCart)
      },
      error:(error:HttpErrorResponse)=>{
        console.log(error)
      }
    });
  }
  showMoreInfo(product: ProductDto) {
    product.showMore = !product.showMore

  }
}
