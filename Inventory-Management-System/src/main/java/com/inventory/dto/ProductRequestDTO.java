package com.inventory.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
	 private String name;
	    private String description;
	    private double price;
	    private int quantity;
	    private Long categoryId;
	    private Long supplierId;
	}