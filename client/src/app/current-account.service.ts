import { Injectable } from '@angular/core';
import { CurrentDistributorService } from './current-distributor.service';
import { CurrentUserService } from './currentuser.service';
import { Account, User, UserAccountDto } from './remote.service';


@Injectable({
  providedIn: 'root'
})
export class CurrentAccountService {
  currentUser:CurrentUserService;
  currentDistributor:CurrentDistributorService;
  accountName="";
  distributorFlag=false;
  constructor(user:CurrentUserService, distributor:CurrentDistributorService) {
    this.currentUser=user;
    this.currentDistributor=distributor;

   }

   setUserAccount(user:User, name:string){
    this.currentUser.setCurrentUser(user);
    this.accountName=name;
    this.distributorFlag=false;
    console.log("Current user set to: ",this.currentUser.getCurrentUser())
   }
   getUserAccount():UserAccountDto{
    let dto:UserAccountDto={
      user: this.currentUser.getCurrentUser(),
      accountName: this.accountName,
      password: "Hidden"
    }
    return dto;

    
   }
   setDistributorAccount(account:Account){
    this.currentDistributor.name=account.distributor.name;
    this.currentDistributor.email=account.distributor.email;
    this.distributorFlag=true;
    this.accountName=account.accountName;
    console.log("Current distributor set to: ",this.accountName)

  }
    getDistributorAccount(){
      return this.currentDistributor;
    }
    
  }

