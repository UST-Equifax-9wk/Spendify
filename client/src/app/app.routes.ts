import { Routes } from '@angular/router';
import { BrowseProductComponent } from './browse-product/browse-product.component';
import { DistributorRegisterComponent } from './distributor-register/distributor-register.component';
import { ManageInventoryComponent } from './manage-inventory/manage-inventory.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterProductComponent } from './register-product/register-product.component';
import { RegisterUserComponent } from './register-user/register-user.component';

export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "register-user", component: RegisterUserComponent},
    {path: "register-product", component: RegisterProductComponent},
    {path: "distributor-register", component: DistributorRegisterComponent},
    {path: "manage-inventory", component: ManageInventoryComponent},
    {path:"browse-product", component: BrowseProductComponent}
];

