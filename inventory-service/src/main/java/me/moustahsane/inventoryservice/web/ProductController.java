package me.moustahsane.inventoryservice.web;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import me.moustahsane.inventoryservice.entity.Product;
import me.moustahsane.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {

    final private ProductRepository productRepository;


    @GetMapping("/products")
    @PreAuthorize("hasAuthority('admin')")
    public List<Product> productList(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product product(@PathVariable String id){
        return productRepository.findById(id).get();
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }



}
