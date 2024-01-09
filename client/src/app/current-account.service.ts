import { Injectable } from '@angular/core';
import { CurrentDistributorService } from './current-distributor.service';
import { CurrentUserService } from './currentuser.service';
import { DistributorDto, NewDistributorDto } from './distributor.service';
import { User, UserAccountDto } from './remote.service';

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
   }
   getUserAccount():UserAccountDto{
    let dto:UserAccountDto={
      user: this.currentUser.getCurrentUser(),
      accountName: this.accountName,
      password: "Hidden"
    }
    return dto;

    
   }
   setDistributorAccount(distributor:DistributorDto, name:string){
    this.currentDistributor.setCurrentDistributor(distributor);
    this.accountName=name;
    this.distributorFlag=true;
    }
    getDistributorAccount():NewDistributorDto{
      let dto:NewDistributorDto={
        distributor: this.currentDistributor.getCurrentDistributor(),
        accountName: this.accountName,
        password: "Hidden"
      }
      return dto;
      
    }
}
