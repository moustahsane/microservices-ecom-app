package me.moustahsane.orderservice.openfieng.clients;


import me.moustahsane.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8007", name = "inventory-service")
public interface InventoryRestClient {

    @GetMapping("/api/products")
    List<Product> allProductsList();

    @GetMapping("/api/products/{id}")
    Product findProduct(@PathVariable("id") String productId);


}
