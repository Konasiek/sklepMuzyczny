import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProductComponent} from "./components/product/product.component";
import {LoginComponent} from "./components/login/login.component";
import {CartComponent} from "./components/cart/cart.component";

const routes: Routes = [
  {path: 'product', component: ProductComponent},
  {path: 'cart', component: CartComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
