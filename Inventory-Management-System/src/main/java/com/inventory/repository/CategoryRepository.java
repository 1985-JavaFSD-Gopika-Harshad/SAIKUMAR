package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}