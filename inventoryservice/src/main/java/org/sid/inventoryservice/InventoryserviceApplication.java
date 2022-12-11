package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository , RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null, "PC", 1000, 10));
            productRepository.save(new Product(null, "Printer", 200, 20));
            productRepository.save(new Product(null, "Scanner", 300, 30));
            productRepository.findAll().forEach(p ->
                    System.out.println(p.getName())
            );
        };
    }
}
