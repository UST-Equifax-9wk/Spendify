import { Component } from '@angular/core';
import { ProductDto } from '../remote.service';
import { CurrentProductService } from '../current-product.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

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
  router: Router;
  isClickable:boolean = true;

  constructor(currentProduct: CurrentProductService, router:Router) {
    this.currentProduct = currentProduct;
    this.router = router;
    this.product = currentProduct.getCurrentProduct();
  }

  returnToBrowsingList() {
    this.router.navigate([`/browse-product`]);
  }
}
