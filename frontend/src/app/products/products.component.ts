import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  product :any;
  constructor(private http:HttpClient,private router:Router) {}
  ngOnInit(): void {
    this.http.get("http://host.docker.internal:8889/PRODUCT-SERVICE/products").subscribe(
      {
        next:(data)=>{
          console.log("products")
          console.log(data)
        this.product=data;
        },
     error:(err) =>{
        console.log(err)
     },
      }
    )
  }
}
