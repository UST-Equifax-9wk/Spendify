import { Routes } from '@angular/router';
import { DistributorRegisterComponent } from './distributor-register/distributor-register.component';
import { ManageInventoryComponent } from './manage-inventory/manage-inventory.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterUserComponent } from './register-user/register-user.component';

export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "distributor-register", component: DistributorRegisterComponent},
    {path: "register-user", component: RegisterUserComponent},
    {path: "manage-inventory", component: ManageInventoryComponent},

];

