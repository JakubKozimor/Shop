package com.books.shop.controller;

import com.books.shop.entity.ProductCategory;
import com.books.shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/allCategory")
    public List<ProductCategory> getListAllCategory() {
        return productCategoryService.getListAllCategory();
    }
}
