package com.shop.service;

import com.shop.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product> getListAllProducts(int page, int size);

    Page<Product> getProductsByCategoryId(int page, int size, Long categoryId);
}
