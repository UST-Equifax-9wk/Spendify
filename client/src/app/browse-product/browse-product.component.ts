import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CartLookup, ProductDto, RemoteService } from '../remote.service';
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
  products:ProductDto[];
  currentAccount:CurrentAccountService;
  isClickable:boolean = true;

  constructor(router:Router, remote: RemoteService, current:CurrentAccountService,currentProduct: CurrentProductService) {
    this.router = router;
    this.remote = remote;
    this.currentProduct = currentProduct;
    this.products = [];
    this.currentAccount=current;
  }

  browseProducts() {
    this.remote.getListOfProducts(this.category).subscribe({
      next:(data) => {
        console.log(data)
        this.products = data.body
      },
      error:(error:HttpErrorResponse) => {
        alert("Could not get list of products")
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
}
