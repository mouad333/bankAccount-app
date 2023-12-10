package com.example.customer_service;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
   @Bean
    CommandLineRunner commandLineRunner (CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Mouad")
                            .lastName("Rhofir")
                            .email("mouad.rhofir@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Yahya")
                            .lastName("Mezara")
                            .email("yahya.mezara@gmail.com")
                            .build()
            );

            customerRepository.saveAll(customerList);
        };
   }
}
