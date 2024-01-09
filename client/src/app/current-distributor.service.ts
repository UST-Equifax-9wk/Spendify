import { Injectable } from '@angular/core';
import { DistributorDto } from './distributor.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentDistributorService {

  name: string;
  email: string;


  constructor() {
    this.name = "";
    this.email = "";
  }

  getName(): String {
    return this.name;
  }

  setCurrentDistributor(distributor: DistributorDto) {
    this.name = distributor.name;
    this.email = distributor.email;
  }

  getCurrentDistributor():DistributorDto {
    let distributor:DistributorDto = {
      name: this.name,
      email: this.email
    }
    return distributor;
  }
}
