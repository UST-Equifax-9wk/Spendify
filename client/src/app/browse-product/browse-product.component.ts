import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BidDto, CartLookup, ProductDto, RemoteService, ReviewDto } from '../remote.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CurrentAccountService } from '../current-account.service';
import { CurrentProductService } from '../current-product.service';

@Component({
  selector: 'app-browse-product',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './browse-product.component.html',
  styleUrl: './browse-product.component.css'
})
export class BrowseProductComponent {

  router:Router;
  remote:RemoteService;
  currentProduct:CurrentProductService;
  category:string = "";
  productName:string = "";
  products:ProductDto[];
  currentAccount:CurrentAccountService;
  isClickable:boolean = true;
  bidPrice:any
  productId:any

  constructor(router:Router, remote: RemoteService, current:CurrentAccountService,currentProduct: CurrentProductService) {
    this.router = router;
    this.remote = remote;
    this.currentProduct = currentProduct;
    this.products = [];
    this.currentAccount=current;
  }

  browseProducts() {
    if(this.category != "" && this.productName != "") {
      this.browseProductsbyCategoryAndProductName();
    }
    else if(this.category != "") {
      this.browseProductsByCategory();
    }
    else if(this.productName != "") {
      this.browseProductsByProductName();
    }
    else {
      alert("No selection made!")
    }
  }

  browseProductsByCategory() {
    this.remote.getListOfProductsByCategory(this.category).subscribe({
      next:(data) => {
        this.products = data.body
      },
      error:(error:HttpErrorResponse) => {
        alert("Could not get list of products by category")
        console.log(error.error)
      }
    }) 
  }

  browseProductsByProductName() {
    this.remote.getListOfProductsByProductName(this.productName).subscribe({
      next:(data) => {
        this.products = data.body
      },
      error:(error:HttpErrorResponse) => {
        alert("Could not get list of products by productName")
        console.log(error.error)
      }
    }) 
  }

  browseProductsbyCategoryAndProductName() {
    this.remote.getListOfProductsByCategoryAndProductName(this.category, this.productName).subscribe({
      next:(data) => {
        this.products = data.body
      },
      error:(error:HttpErrorResponse) => {
        alert("Could not get list of products by category and productName")
        console.log(error.error)
      }
    }) 
  }

  showMoreInfo(product: ProductDto) {
    product.showMore = !product.showMore
  }

  productInformation(product:ProductDto) {
    this.currentProduct.setCurrentProduct(product);
    this.router.navigate([`/product-information/${product.productName}`]);
  }

  addToCart(product:ProductDto){
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
    let lookup:CartLookup={
      cartLookUpId: 0,
      quantity: q,
      product: product
    }
    this.remote.editCart(this.currentAccount.accountName,lookup).subscribe({
      next:(data)=>{alert("success")},
      error:(error)=>{alert("Denied: error sending to server")}
    })
  }

  makeBid(productId : any) {
    let bid = window.prompt("Enter bid amount");
    if(bid == "" || bid == null) {
      alert("Bid cancelled")
      return
    }
    let regex = /(?=.*?\d)^\$?(([1-9]\d{0,2}(,\d{3})*)|\d+)?(\.\d{1,2})?$/ //Regex for currency validation
    if(!regex.test(bid)) {
      alert("Please enter a valid amount and try again.")
      return
    }
    let b = parseInt(bid)
    let bidDto : BidDto = {
      accountName : this.currentAccount.accountName,
      bid : b
    }
    this.remote.postBid(productId, bidDto).subscribe({
      next:(data)=>{alert(`You have posted a $${b} bid for this item.`)},
      error:(error)=>{alert(error.error)}
    })
  }
}
