package me.moustahsane.orderservice.repository;

import me.moustahsane.orderservice.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
