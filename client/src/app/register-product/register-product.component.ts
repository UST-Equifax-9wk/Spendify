import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category, ProductDto, RemoteService } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

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
  accountName : string = "Walmart"
  productName : string = ""
  price : any
  category : string = ""
  weight : any
  stock : any
  discount : any
  description : string = ""
  reviewList: number[] = []
  cartLookupList: number[] = []
  showMore: boolean = false;
  
  constructor(router : Router, remoteService : RemoteService) {
    this.router = router
    this.remoteService = remoteService
  }

  postProduct() {
    let productDto : ProductDto = {
      productName : this.productName,
      price : this.price,
      category : this.category,
      weight : this.weight,
      stock : this.stock,
      discount : this.discount,
      description : this.description,
      reviewList : this.reviewList,
      cartLookupList: this.cartLookupList,
      showMore: this.showMore
    }
    this.remoteService.postNewProduct(this.accountName, productDto).subscribe({
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
