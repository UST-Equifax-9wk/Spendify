import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CurrentAccountService } from '../current-account.service';
import { DistributorService, NewDistributorDto } from '../distributor.service';
import { PasswordStrengthDirective } from '../password-strength.directive';

@Component({
  selector: 'app-distributor-register',
  standalone: true,
  imports: [CommonModule, FormsModule, PasswordStrengthDirective],
  templateUrl: './distributor-register.component.html',
  styleUrl: './distributor-register.component.css'
})
export class DistributorRegisterComponent{

  distributorService: DistributorService;
  currentAccountService: CurrentAccountService;
  name: string;
  email: string;
  password: string;

  constructor(private router: Router, currentAccountService: CurrentAccountService, distributorService: DistributorService) { 
    this.name = '';
    this.email = '';
    this.password = '';
    this.distributorService = distributorService;
    this.currentAccountService = currentAccountService;
  }


  
  onSubmit() {
    let newDistributor: NewDistributorDto = {
      distributor: {
        name: this.name,
        email: this.email
      },
      password: this.password,
      accountName: this.name
    };
    this.distributorService.registerDistributor(newDistributor)
    .subscribe({
      next: data => {
        let res = data.body as NewDistributorDto;
        this.currentAccountService.setDistributorAccount(res.distributor, res.accountName);
        console.log(data);
      },
      error: error => {
        console.error('There was an error!', error);
      }
    });
  }
}
