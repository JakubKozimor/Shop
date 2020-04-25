package com.books.shop.service;

import com.books.shop.dao.ProductCategoryRepository;
import com.books.shop.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImp implements ProductCategoryService {

    ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImp(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getListAllCategory() {
        return productCategoryRepository.findAll();
    }
}
