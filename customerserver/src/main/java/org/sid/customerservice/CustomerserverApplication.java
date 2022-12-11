package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerserverApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository , RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null, "Amine", "email1"));
            customerRepository.save(new Customer(null, "Hassan", "email2"));
            customerRepository.save(new Customer(null, "Mohamed", "email3"));
            customerRepository.findAll().forEach(c ->
                    System.out.println(c.toString())
            );
        };
    }
}
