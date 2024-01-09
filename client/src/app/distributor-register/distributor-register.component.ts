import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
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
  name: string;
  email: string;
  password: string;

  constructor(private router: Router, distributorService: DistributorService) { 
    this.name = '';
    this.email = '';
    this.password = '';
    this.distributorService = distributorService;
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
        console.log(data);
      },
      error: error => {
        console.error('There was an error!', error);
      }
    });
  }
}
