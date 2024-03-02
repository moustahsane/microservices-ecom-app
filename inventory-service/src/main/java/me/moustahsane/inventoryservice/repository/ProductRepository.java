package me.moustahsane.inventoryservice.repository;

import me.moustahsane.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
