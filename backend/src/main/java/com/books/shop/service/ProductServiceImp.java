package com.books.shop.service;

import com.books.shop.dao.ProductRepository;
import com.books.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired


    @Override
    public List<Product> getListAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }
}
