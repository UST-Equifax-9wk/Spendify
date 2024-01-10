import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductDto, RemoteService } from '../remote.service';
import { HttpErrorResponse } from '@angular/common/http';
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
  isClickable:boolean = true;

  constructor(router:Router, remote: RemoteService, currentProduct: CurrentProductService) {
    this.router = router;
    this.remote = remote;
    this.currentProduct = currentProduct;
    this.products = [];
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
}
