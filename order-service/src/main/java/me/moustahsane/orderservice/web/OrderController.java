package me.moustahsane.orderservice.web;

import lombok.RequiredArgsConstructor;
import me.moustahsane.orderservice.entity.Order;
import me.moustahsane.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor()
public class OrderController {

    final OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){

        return orderService.getAllOrders();

    }


    @GetMapping("/orders/{id}")
    public Order getAllOrders(@PathVariable("id") String orderId){

        return orderService.getOrder(orderId);

    }
}
