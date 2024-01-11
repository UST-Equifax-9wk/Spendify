import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RemoteService, ReviewDto } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-review-product',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './review-product.component.html',
  styleUrl: './review-product.component.css'
})
export class ReviewProductComponent {
  router : Router
  remoteService : RemoteService
  currentAccountName : string = "chuynh" //TODO: get current user's account name
  productId : number = 3 //TODO: get product ID of item being reviewed
  rating : any
  reviewText : string = ""

  constructor(router : Router, remoteService : RemoteService) {
    this.router = router
    this.remoteService = remoteService
  }

  postReview() {
    let reviewDto : ReviewDto = {
      accountName : this.currentAccountName,
      text : this.reviewText,
      rating : this.rating
    }
    if(this.rating < 1 || this.rating > 5) {
      alert("Please enter a rating.")
      return
    }
    this.remoteService.postNewReview(reviewDto, this.productId).subscribe({
      next: (data) => {
        alert("Thank you for submitting a review. We value your feedback!")
        console.log(data)
      },
      error: (error:HttpErrorResponse) => {
        alert("Failed to submit a review. Please try again later.")
        console.log(error.error)
      }
    })
  }
}