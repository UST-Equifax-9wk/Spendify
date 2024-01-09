import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RemoteService } from '../remote.service';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register-user.component.html',
  styleUrl: './register-user.component.css'
})
export class RegisterUserComponent {
  remote:RemoteService;
  firstName="";
  lastName="";
  email="";
  address="";
  accountName="";
  password="";
  confirmPassword="";
  clicked=false;
  constructor(remoteService:RemoteService){
    this.remote=remoteService;
  }

  register(){
    this.clicked=true;
  }
}
