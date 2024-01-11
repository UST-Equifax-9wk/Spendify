import { Injectable } from '@angular/core';
import { ProductDto, RemoteService, ReviewDto } from './remote.service';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CurrentProductService {

  remote:RemoteService;
  productId: number;
  productName: string;
  price: number;
  category: string;
  weight: number;
  stock: number;
  discount: number;
  description: string;
  reviewList: ReviewDto[];
  cartLookupList: number[];
  showMore: boolean;

  constructor(remote:RemoteService) { 
    this.remote = remote;
    this.productId = 0;
    this.productName = "";
    this.price = 0;
    this.category = "";
    this.weight = 0;
    this.stock = 0;
    this.discount = 0;
    this.description = "";
    this.reviewList = [];
    this.cartLookupList = [];
    this.showMore = false;
  }
/*
  setReviewList(product:ProductDto) {
    this.remote.getListOfReviews(this.productId).subscribe ({
      next: (data) => {
        //console.log(data)
        this.reviewList = data.body;
      },
      error: (error:HttpErrorResponse) => {
        alert("Error: failed to obtain review!")
        console.log(error)
      }
    })
  } 
  */

  setCurrentProduct(product: ProductDto) {
    this.productId = product.productId!;
    this.productName = product.productName;
    this.price = product.price;
    this.category = product.category;
    this.weight = product.weight;
    this.stock = product.stock;
    this.discount = product.discount;
    this.description = product.description;
  }

  getCurrentProduct():ProductDto {
    let product:ProductDto = {
      productId: this.productId,
      productName: this.productName,
      price: this.price,
      category: this.category,
      weight: this.weight,
      stock: this.stock,
      discount: this.discount,
      description: this.description,
      reviewList: this.reviewList,
      cartLookupList: this.cartLookupList,
      showMore: false
    }

    return product;
  }

}
