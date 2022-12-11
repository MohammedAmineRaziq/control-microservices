package org.sid.billingservice.feign;

import org.sid.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductItemRestClient {
    @GetMapping("/products")
    PagedModel<Product> pageProducts(@RequestParam(name = "page") int page,
                                     @RequestParam(name = "size") int size);
    /*PagedModel<Product> pageProducts(@QueryParam("page") int page,
                                     @QueryParam("size") int size);*/
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
