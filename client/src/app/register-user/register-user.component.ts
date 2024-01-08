import { Component } from '@angular/core';
import { RemoteService } from '../remote.service';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [],
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
  confirmPasword="";
  constructor(remoteService:RemoteService){
    this.remote=remoteService;
  }

  register(){
    
  }
}
