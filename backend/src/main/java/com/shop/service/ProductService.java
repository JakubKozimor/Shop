package com.shop.service;

import com.shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> getListAllProducts(Pageable pageable);

    Page<Product> getProductsByCategoryId(Pageable pageable, Long categoryId);
}
