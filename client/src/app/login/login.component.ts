import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Account, RemoteService } from '../remote.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CurrentAccountService } from '../current-account.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username: string = '';
  password: string = '';
  currentAccount:CurrentAccountService;
  constructor(private remoteService:RemoteService, currentAccount:CurrentAccountService) {
    this.currentAccount=currentAccount;
  }

signIn(){
  this.remoteService.login(this.username, this.password).subscribe({
    next: (data) => {
      let account = data.body as Account;
      if(account.distributor){
        this.currentAccount.setDistributorAccount(account);
      }
      else this.currentAccount.setUserAccount(account.user, account.accountName)
      alert("Success")
    },
    error: (error: HttpErrorResponse) => {
      alert("Denied: Unknown Error");
    }
  })
  }
}
