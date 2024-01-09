import { Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { RegisterProductComponent } from './register-product/register-product.component';

export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "register-user", component: RegisterUserComponent},
    {path: "register-product", component: RegisterProductComponent}
];
