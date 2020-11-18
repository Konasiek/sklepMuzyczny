import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ProductComponent} from "./components/product/product.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ProductService} from "./services/product.service";
import {LoginComponent} from './components/login/login.component';
import {FormsModule} from "@angular/forms";
import {SignupComponent} from "./components/signup/signup.component";
import {CookieService} from "ngx-cookie-service";
import {JwtInterceptor} from "./_interceptors/jwt-interceptor.service";
import {ErrorInterceptor} from "./_interceptors/error-interceptor.service";


@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    LoginComponent,
    SignupComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [
    CookieService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    ProductService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
