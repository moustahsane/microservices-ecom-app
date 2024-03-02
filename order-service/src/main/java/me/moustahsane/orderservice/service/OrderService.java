package me.moustahsane.orderservice.service;


import lombok.RequiredArgsConstructor;
import me.moustahsane.orderservice.entity.Order;
import me.moustahsane.orderservice.repository.OrderRepository;
import me.moustahsane.orderservice.openfieng.clients.InventoryRestClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryRestClient inventoryRestClient;

    public List<Order> getAllOrders() {
        return  orderRepository.findAll().stream().map((order -> {
            order.getProductItems().forEach(productItem -> {
                productItem.setProduct(inventoryRestClient.findProduct(productItem.getProductId()));
            });
            return order;
        })).collect(Collectors.toList());
    }

    public Order getOrder(String orderId) {

        Order order =  orderRepository.findById(orderId).get();
        order.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryRestClient.findProduct(productItem.getProductId()));
        });
        return  order;
    }
}
