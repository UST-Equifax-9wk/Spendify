import { Injectable } from '@angular/core';
import { ProductDto } from './remote.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentProductService {
  productId: any
  productName: string;
  price: number;
  category: string;
  weight: number;
  stock: number;
  threshold: number;
  biddable: boolean;
  currentBid: number;
  discount: number;
  description: string;
  reviewList: number[];
  cartLookupList: number[];
  showMore: boolean;

  constructor() { 
    this.productId
    this.productName = "";
    this.price = 0;
    this.category = "";
    this.weight = 0;
    this.stock = 0;
    this.threshold = 0;
    this.biddable = false;
    this.currentBid = 0;
    this.discount = 0;
    this.description = "";
    this.reviewList = [];
    this.cartLookupList = [];
    this.showMore = false;
  }

  setCurrentProduct(product: ProductDto) {
    this.productName = product.productName;
    this.price = product.price;
    this.category = product.category;
    this.weight = product.weight;
    this.stock = product.stock;
    this.discount = product.discount;
    this.description = product.description;
    this.threshold = product.threshold;
    this.biddable = product.biddable;
    this.currentBid = product.currentBid;
  }

  getCurrentProduct():ProductDto {
    let product:ProductDto = {
      productId : this.productId,
      productName: this.productName,
      price: this.price,
      category: this.category,
      weight: this.weight,
      stock: this.stock,
      threshold: this.threshold,
      biddable: this.biddable,
      currentBid: this.currentBid,
      discount: this.discount,
      description: this.description,
      reviewList: this.reviewList,
      cartLookupList: this.cartLookupList,
      showMore: false
    }

    return product;
  }

}
