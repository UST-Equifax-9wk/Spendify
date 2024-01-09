import { Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterUserComponent } from './register-user/register-user.component';

export const routes: Routes = [
    {path: "navbar", component: NavbarComponent},
    {path: "register-user", component: RegisterUserComponent}
];
