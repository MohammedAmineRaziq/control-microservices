import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import { KeycloakSecurityService } from '../keycloak-security.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent {
  orderDetails :any;
  orderId!: number;
  constructor(private http:HttpClient, private router:Router,private securityService:KeycloakSecurityService, private route:ActivatedRoute) {
    this.orderId=route.snapshot.params['orderID']
  }
  ngOnInit():void{
    var token=this.securityService.kc.token;
    this.http.get("http://host.docker.internal:8889/BILLING-SERVICE/fullBill/"+this.orderId,{headers:new HttpHeaders({"Authorization":"Bearer "+token})}).subscribe({
      next : (data)=>{
        this.orderDetails=data;
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id);
  }
}
