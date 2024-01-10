import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RemoteService } from '../remote.service';
import { HttpErrorResponse } from '@angular/common/http';

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
  
  constructor(private remoteService:RemoteService) {}

signIn(){
  this.remoteService.login(this.username, this.password).subscribe({
    next: (data) => {
      alert("Success")
    },
    error: (error: HttpErrorResponse) => {
      alert("Denied: Unknown Error");
    }
  })
  }
}
