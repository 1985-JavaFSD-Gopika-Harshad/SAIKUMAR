package com.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.SupplierRequestDTO;
import com.inventory.dto.SupplierResponseDTO;
import com.inventory.model.Supplier;
import com.inventory.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierResponseDTO createSupplier(SupplierRequestDTO request) {
        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setContactEmail(request.getContactEmail());
        Supplier savedSupplier = supplierRepository.save(supplier);
        return mapToResponseDTO(savedSupplier);
    }

    public List<SupplierResponseDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    private SupplierResponseDTO mapToResponseDTO(Supplier supplier) {
        SupplierResponseDTO dto = new SupplierResponseDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setContactEmail(supplier.getContactEmail());
        return dto;
    }
}
