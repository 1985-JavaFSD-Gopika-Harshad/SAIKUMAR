package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.SupplierRequestDTO;
import com.inventory.dto.SupplierResponseDTO;
import com.inventory.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public SupplierResponseDTO createSupplier(@RequestBody SupplierRequestDTO request) {
        return supplierService.createSupplier(request);
    }

    @GetMapping
    public List<SupplierResponseDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
}