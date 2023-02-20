import {NgModule} from "@angular/core";
import {RouterModule , Routes} from "@angular/router";
import {ProductsComponent} from "./products/products.component";
import {CustomersComponent} from "./customers/customers.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";
import { ChartComponent } from "./chart/chart.component";


const routes:Routes=[
  {
    path:"products", component : ProductsComponent
  },
  {
    path:"customers", component : CustomersComponent
  },
  {
    path:"order-details/:orderID", component : OrderDetailsComponent
  },
  {
    path:"analytics", component : ChartComponent
  }
]

@NgModule({
  imports : [RouterModule.forRoot(routes)],
  exports : [RouterModule]
})
export class AppRoutingModule{}
