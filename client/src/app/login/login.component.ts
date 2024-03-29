import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CurrentAccountService } from '../current-account.service';
import { Router } from '@angular/router';
import { Account, RemoteService } from '../remote.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  router : Router
  username: string = '';
  password: string = '';
  currentAccount:CurrentAccountService;
  constructor(private remoteService:RemoteService, currentAccount:CurrentAccountService, router:Router) {
    this.currentAccount=currentAccount;
    this.router=router
  }

signIn(){
  this.remoteService.login(this.username, this.password).subscribe({
    next: (data) => {
      let account = data.body as Account;
      if(account.distributor){
        this.currentAccount.setDistributorAccount(account.distributor, account.accountName);
      }
      else this.currentAccount.setUserAccount(account.user, account.accountName)
      alert("Success")
      this.router.navigate(["browse-product"])
    },
    error: (error: HttpErrorResponse) => {
      alert("Denied: Unknown Error");
    }
  })
  }
}
