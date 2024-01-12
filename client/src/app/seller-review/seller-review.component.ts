import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { CurrentProductService } from '../current-product.service';

@Component({
  selector: 'app-seller-review',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './seller-review.component.html',
  styleUrl: './seller-review.component.css'
})
export class SellerReviewComponent {

  reviews: any[] = [];
  currentProductService: CurrentProductService;

  constructor(currentProductService: CurrentProductService) {
    this.currentProductService = currentProductService;
   }

  ngOnInit(): void {
    this.reviews = this.currentProductService.getCurrentProduct().reviewList;
      
    console.log(this.reviews);
  }
}
