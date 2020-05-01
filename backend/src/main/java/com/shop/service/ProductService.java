package com.shop.service;

import com.shop.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListAllProducts();

    List<Product> getProductsByCategoryId(Long categoryId);
}
