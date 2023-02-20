import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakSecurityService } from '../keycloak-security.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers:any
  constructor(private http:HttpClient,private router:Router,private securityService:KeycloakSecurityService) { }

   getOrders(c:any)
  {
    this.router.navigateByUrl("/order-details/"+c.id)
  }
  ngOnInit(): void {
    var token=this.securityService.kc.token;
    this.http.get("http://host.docker.internal:8889/CUSTOMER-SERVICE/customers",{headers:new HttpHeaders({"Authorization":"Bearer "+token})}).subscribe(
      {
        next:(data)=>{
          console.log("customers ")
          console.log(data)
        this.customers=data;
        },
     error:(err) =>{
      console.log("error")
        console.log(err)
     },
      }
    )
  }

}
