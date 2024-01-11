import { Routes } from '@angular/router';
import { BrowseProductComponent } from './browse-product/browse-product.component';
import { CartComponent } from './cart/cart.component';
import { DistributorRegisterComponent } from './distributor-register/distributor-register.component';
import { LoginComponent } from './login/login.component';
import { ManageInventoryComponent } from './manage-inventory/manage-inventory.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductInformationComponent } from './product-information/product-information.component';
import { RegisterProductComponent } from './register-product/register-product.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { ReviewProductComponent } from './review-product/review-product.component';


export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "register-user", component: RegisterUserComponent},
    {path: "register-product", component: RegisterProductComponent},
    {path: "distributor-register", component: DistributorRegisterComponent},
    {path: "manage-inventory", component: ManageInventoryComponent},
    {path:"cart", component: CartComponent},
    {path: "login", component: LoginComponent},
    {path: "product-information/:productName", component: ProductInformationComponent},
    {path: "review-product", component: ReviewProductComponent},
    {path:"browse-product", component: BrowseProductComponent}
];

