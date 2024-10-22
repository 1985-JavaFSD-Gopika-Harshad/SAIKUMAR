package com.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.CategoryRequestDTO;
import com.inventory.dto.CategoryResponseDTO;
import com.inventory.model.Category;
import com.inventory.repository.CategoryRepository;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        Category category = new Category();
        category.setName(request.getName());
        Category savedCategory = categoryRepository.save(category);
        return mapToResponseDTO(savedCategory);
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    private CategoryResponseDTO mapToResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}