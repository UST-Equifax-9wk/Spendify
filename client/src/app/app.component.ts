import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DistributorRegisterComponent } from './distributor-register/distributor-register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterProductComponent } from './register-product/register-product.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NavbarComponent, RegisterProductComponent, DistributorRegisterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Spendify';
}
