package me.moustahsane.orderservice;

import me.moustahsane.orderservice.entity.Order;
import me.moustahsane.orderservice.entity.OrderState;
import me.moustahsane.orderservice.entity.ProductItem;
import me.moustahsane.orderservice.repository.OrderRepository;
import me.moustahsane.orderservice.repository.ProductItemRepository;
import me.moustahsane.orderservice.openfieng.clients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository, ProductItemRepository productItemRepository, InventoryRestClient inventoryRestClient){

        return  args -> {


            List<String> allProducts = List.of("P00","P01","P02");
            Order order;

            for (int i = 0; i < 5; i++) {
                order = Order.builder()
                        .date(LocalDate.now())
                        .state(OrderState.PENDING)
                        .build();
                Order orderSaved = orderRepository.save(order);

                allProducts.forEach( productId -> {
                    ProductItem productItem = ProductItem.builder()
                            .productId(productId)
                            .price(Math.random()*5000)
                            .quantity(new Random().nextInt(20))
                            .order(orderSaved)
                            .build();

                    productItemRepository.save(productItem);
                });

            }


            allProducts.stream().forEach(System.out::println);
        };
    }

}
