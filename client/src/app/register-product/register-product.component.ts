import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CurrentAccountService } from '../current-account.service';
import { ProductDto, RemoteService, ReviewDto } from '../remote.service';

@Component({
  selector: 'app-register-product',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register-product.component.html',
  styleUrl: './register-product.component.css'
})

export class RegisterProductComponent {
  router : Router
  remoteService : RemoteService
  currentAccountService : CurrentAccountService
  accountName : string = ""
  productName : string = ""
  price : any
  threshold : any
  category : string = ""
  weight : any
  stock : any
  discount : any
  description : string = ""
  reviewList: ReviewDto[] = []
  cartLookupList: number[] = []
  showMore: boolean = false;
  biddable : boolean = false;
  currentBid : any
  
  constructor(router : Router, remoteService : RemoteService, currentAccountService : CurrentAccountService) {
    this.router = router
    this.currentAccountService = currentAccountService
    this.remoteService = remoteService
    this.currentAccountService = currentAccountService;
  }

  postProduct() {
    if(this.biddable == true) {
      this.stock = 1
      this.threshold = 0
    }
    this.accountName = this.currentAccountService.accountName;
    let productDto : ProductDto = {
      productName : this.productName,
      price : this.price,
      category : this.category,
      weight : this.weight,
      stock : this.stock,
      biddable : this.biddable,
      discount : this.discount,
      description : this.description,
      reviewList : this.reviewList,
      cartLookupList: this.cartLookupList,
      showMore: this.showMore,
      threshold : this.threshold,
      currentBid : this.currentBid
    }
    this.remoteService.postNewProduct(this.currentAccountService.accountName, productDto).subscribe({
      next: (data) => {
        alert(`${this.productName} has successfully been listed for sale.`)
        console.log(data)
      },
      error: (error:HttpErrorResponse) => {
        alert("Failed to list product for sale.")
        console.log(error.error)
      }
    })
  }
}
