package com.inventory.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String categoryName;
    private String supplierName;
}