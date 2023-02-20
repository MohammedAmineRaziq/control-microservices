package org.sid.billingservice;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.models.Customer;
import org.sid.billingservice.models.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    @Bean
    public Consumer<Bill> billConsumer()
    {
        return  (bill)->{
            System.out.println("**********");
            Bill newBill=new Bill(bill.getId(),bill.getBillingDate(),null,bill.getCustomerID(),bill.getCustomer());
            for (ProductItem productItem:bill.getProductItems())
            {
                ProductItem newProductItem=new ProductItem(productItem.getId(),productItem.getQuantity(),productItem.getPrice(),productItem.getProductID(),productItem.getBill(),productItem.getProductName());
                productItemRepository.save(newProductItem);
            }
            billRepository.save(newBill);
        };
    }
}
