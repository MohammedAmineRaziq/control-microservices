package org.sid.billingservice.feign;

import org.sid.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    public Collection<Customer> getAllCustomers();
}
