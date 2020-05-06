package com.shop.service.impl;

import com.shop.repository.ProductCategoryRepository;
import com.shop.entity.ProductCategory;
import com.shop.service.interfaces.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getListAllCategory() {
        return productCategoryRepository.findAll();
    }
}
