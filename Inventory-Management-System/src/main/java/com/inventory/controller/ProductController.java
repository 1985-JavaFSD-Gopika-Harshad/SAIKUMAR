package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.ProductRequestDTO;
import com.inventory.dto.ProductResponseDTO;
import com.inventory.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}/quantity")
    public void updateQuantity(@PathVariable Long id, @RequestParam int quantity) {
        productService.updateQuantity(id, quantity);
    }

    @GetMapping("/low-stock")
    public List<ProductResponseDTO> getLowStockProducts(@RequestParam int threshold) {
        return productService.getLowStockProducts(threshold);
    }
}