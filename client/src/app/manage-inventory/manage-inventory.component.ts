import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CurrencyFormatDirective } from '../currency-format.directive';
import { CurrentAccountService } from '../current-account.service';
import { ProductDto, RemoteService } from '../remote.service';

@Component({
  selector: 'app-manage-inventory',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink, CurrencyFormatDirective],
  templateUrl: './manage-inventory.component.html',
  styleUrl: './manage-inventory.component.css'
})
export class ManageInventoryComponent {
validateField(_t13: ProductDto) {
  if (Number(_t13.price) < 0) {
    _t13.price = 0;
  }
  if (Number(_t13.stock) < 0) {
    _t13.stock = 0;
  }
}

  inventory: ProductDto[];
  remoteService : RemoteService
  currentAccountService: CurrentAccountService;

  constructor(currentAccountService: CurrentAccountService, private router : Router, remoteService : RemoteService) {
    this.currentAccountService = currentAccountService;
    this.remoteService = remoteService;
    this.inventory = [];
   }

  ngOnInit(): void {
    // Here you would typically fetch the inventory data from a service
    //console.log(this.currentAccountService.getDistributorAccount());
    this.remoteService.getAccount(this.currentAccountService.accountName).subscribe({
      next: (response) => {
      let account = JSON.parse(JSON.stringify(response.body ? response.body : []));
      //console.log(account);
      account.productList.forEach((product: ProductDto) => {
        this.inventory.push(JSON.parse(JSON.stringify(product)));
      })
      this.inventory.forEach((item => item.isEditing = false));
      this.inventory.forEach((item => item.price = Number(item.price)));
      this.inventory.forEach((item => item.stock = Number(item.stock)));
    }
  });
}

toggleEdit(item: any): void {
  item.isEditing = !item.isEditing;
  // Other logic for handling the edit state...
}



updateInventory(item: ProductDto): void {
  if (item.isEditing) {
    // Handle the save logic here
    console.log('Saving item:', item);
    this.remoteService.updateProduct(item).subscribe({
      next: (response) => {
        console.log(response);
      }
    });
    console.log(this.inventory);
  }
  this.toggleEdit(item); // Toggle editing state
}
}

