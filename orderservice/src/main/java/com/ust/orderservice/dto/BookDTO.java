package com.ust.orderservice.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private Double price;
}