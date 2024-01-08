import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { DistributorServiceService, NewDistributorDto } from '../distributor-service.service';
import { PasswordStrengthDirective } from '../password-strength.directive';


@Component({
  selector: 'app-distributor-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './distributor-register.component.html',
  hostDirectives: [PasswordStrengthDirective],
  styleUrl: './distributor-register.component.css'
})
export class DistributorRegisterComponent{

  distributorService: DistributorServiceService;
  name: string;
  email: string;
  password: string;

  constructor(private router: Router, distributorService: DistributorServiceService) { 
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
        //this.router.navigate(['/distributor-login']);
      },
      error: error => {
        console.error('There was an error!', error);
      }
    });
  }
    //this.router.navigate(['/distributor-login']);
    handleError(error: HttpErrorResponse) {
  }
}
