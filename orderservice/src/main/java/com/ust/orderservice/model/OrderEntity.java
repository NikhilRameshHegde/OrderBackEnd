package com.ust.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "order_entity")  // Renaming the table to avoid using 'order' (which is reserved in SQL)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Long> bookIds;

    private Double totalPrice;

    private LocalDateTime createdDate;
}