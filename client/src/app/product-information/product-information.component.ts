import { Component, OnInit } from '@angular/core';
import { ProductDto, RemoteService, ReviewDto } from '../remote.service';
import { CurrentProductService } from '../current-product.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-product-information',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './product-information.component.html',
  styleUrl: './product-information.component.css'
})
export class ProductInformationComponent {

  product:ProductDto;
  currentProduct:CurrentProductService;
  remote:RemoteService;
  router: Router;
  reviews: ReviewDto[];
  isClickable:boolean = true;

  constructor(currentProduct: CurrentProductService, remote:RemoteService, router:Router) {
    this.remote = remote;
    this.router = router;
    this.currentProduct = currentProduct;
    this.product = currentProduct.getCurrentProduct();
    this.reviews = [];
    this.getReviewList(currentProduct.getCurrentProduct());
  }

  getReviewList(product:ProductDto) {
    this.remote.getListOfReviews(product.productId!).subscribe ({
      next: (data) => {
        this.reviews = data.body;
        console.log(this.reviews)
      },
      error: (error:HttpErrorResponse) => {
        alert("Error: failed to obtain review!")
        console.log(error)
      }
    })
  }

  returnToBrowsingList() {
    this.router.navigate([`/browse-product`]);
  }
}
