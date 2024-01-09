import { Injectable } from '@angular/core';
import { CurrentUserService } from './currentuser.service';
import { User, UserAccountDto } from './remote.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentAccountService {
  currentUser:CurrentUserService;
  accountName="";
  distributorFlag=false;
  constructor(user:CurrentUserService) {
    this.currentUser=user;

   }

   setUserAccount(user:User, name:string){
    this.currentUser.setCurrentUser(user);
    this.accountName=name;
    this.distributorFlag=false;
   }
   getUserAccount():UserAccountDto{
    let dto:UserAccountDto={
      user: this.currentUser.getCurrentUser(),
      accountName: this.accountName,
      password: "Hidden"
    }
    return dto;

    
   }
   setDistributorAccount(){
      alert("TO DO SET DISTRIBUTOR ACCOUNT")
    }
    getDistributorAccount(){
      alert("TO DO GET DISTRIBUTOR ACCOUNT")
    }
}
