import { Routes } from '@angular/router';
import { DistributorRegisterComponent } from './distributor-register/distributor-register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { RegisterProductComponent } from './register-product/register-product.component';
import { LoginComponent } from './login/login.component';
import { ReviewProductComponent } from './review-product/review-product.component';
import { BrowseProductComponent } from './browse-product/browse-product.component';
import { CartComponent } from './cart/cart.component';
import { ProductInformationComponent } from './product-information/product-information.component';

export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "register-user", component: RegisterUserComponent},
    {path: "register-product", component: RegisterProductComponent},
    {path: "distributor-register", component: DistributorRegisterComponent},
    {path:"cart", component: CartComponent},
    {path: "login", component: LoginComponent},
    {path: "product-information/:productName", component: ProductInformationComponent},
    {path: "review-product", component: ReviewProductComponent},
    {path:"browse-product", component: BrowseProductComponent}
];

