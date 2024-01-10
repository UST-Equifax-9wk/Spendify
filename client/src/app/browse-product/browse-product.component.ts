import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductDto, RemoteService } from '../remote.service';
import { HttpErrorResponse } from '@angular/common/http';

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
  category:string = "";
  products:ProductDto[];
  //ShowMore:boolean = true;
  //visible:boolean = false;

  constructor(router:Router, remote: RemoteService) {
    this.router = router;
    this.remote = remote;
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
    //this.ShowMore = !this.ShowMore
    //this.visible = !this.visible
  }
}
