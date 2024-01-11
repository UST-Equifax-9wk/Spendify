import { Component } from '@angular/core';
import { RouterLink, RouterModule, RouterOutlet } from '@angular/router';
import { CurrentAccountService } from '../current-account.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, RouterOutlet, RouterModule, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  currentAccount: CurrentAccountService;
  constructor(currentAccount:CurrentAccountService){
    this.currentAccount=currentAccount;
  }
}
