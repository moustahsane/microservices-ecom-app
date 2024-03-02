package me.moustahsane.orderservice.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private String id;

    private String name;

    private double price;

    private int quantity;

}
