package com.example.demoshop.service;

import com.example.demoshop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void addToUserBucket(Long productId, String username);
}
