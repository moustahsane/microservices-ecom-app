package me.moustahsane.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    private LocalDate date;


    @Enumerated(EnumType.STRING)
    private OrderState state;

    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;



}
