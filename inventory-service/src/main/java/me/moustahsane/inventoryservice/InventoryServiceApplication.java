package me.moustahsane.inventoryservice;

import me.moustahsane.inventoryservice.entity.Product;
import me.moustahsane.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return  args -> {
            Product product1 = Product.builder().id("P00").name("Laptop").price(1200.00).quantity(12).build();
            Product product2 = Product.builder().id("P01").name("Printer").price(200.00).quantity(2).build();
            Product product3 = Product.builder().id("P02").name("Smartphone").price(100.00).quantity(10).build();
            productRepository.saveAll(List.of(product1, product2, product3));
        };
    }
}
