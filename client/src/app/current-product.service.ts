import { Injectable } from '@angular/core';
import { ProductDto } from './remote.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentProductService {

  productName: string;
  price: number;
  category: string;
  weight: number;
  stock: number;
  discount: number;
  description: string;
  reviewList: number[];
  cartLookupList: number[];
  showMore: boolean;

  constructor() { 
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

  setCurrentProduct(product: ProductDto) {
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
