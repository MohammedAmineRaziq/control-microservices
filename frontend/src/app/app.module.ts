import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterOutlet} from "@angular/router";
import {AppRoutingModule} from "./app-routing.module";
import { CustomersComponent } from './customers/customers.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import {KeycloakSecurityService} from "./keycloak-security.service";
import { ChartComponent } from './chart/chart.component';

function kcFactory(kcSecurity: KeycloakSecurityService){
    return ()=>{kcSecurity.init();}
}
@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    OrderDetailsComponent,
    ChartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [{provide: APP_INITIALIZER,deps:[KeycloakSecurityService],useFactory:kcFactory,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
