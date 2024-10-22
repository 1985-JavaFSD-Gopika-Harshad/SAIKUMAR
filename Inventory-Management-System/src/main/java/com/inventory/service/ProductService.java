package com.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.ProductRequestDTO;
import com.inventory.dto.ProductResponseDTO;
import com.inventory.model.Category;
import com.inventory.model.Product;
import com.inventory.model.Supplier;
import com.inventory.repository.CategoryRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.SupplierRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
        Supplier supplier = supplierRepository.findById(request.getSupplierId()).orElseThrow();

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(category);
        product.setSupplier(supplier);

        Product savedProduct = productRepository.save(product);
        return mapToResponseDTO(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public void updateQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setQuantity(quantity);
        productRepository.save(product);
    }

    public List<ProductResponseDTO> getLowStockProducts(int threshold) {
        return productRepository.findByQuantityLessThan(threshold).stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    private ProductResponseDTO mapToResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCategoryName(product.getCategory().getName());
        dto.setSupplierName(product.getSupplier().getName());
        return dto;
    }
}