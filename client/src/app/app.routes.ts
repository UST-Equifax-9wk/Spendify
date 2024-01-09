import { Routes } from '@angular/router';
import { DistributorRegisterComponent } from './distributor-register/distributor-register.component';
import { NavbarComponent } from './navbar/navbar.component';

export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "distributor-register", component: DistributorRegisterComponent}

];
