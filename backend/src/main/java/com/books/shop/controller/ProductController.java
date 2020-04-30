package com.books.shop.controller;

import com.books.shop.entity.Product;
import com.books.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    public List<Product> getListAllProducts() {
        return productService.getListAllProducts();
    }

    @GetMapping("/productsByCategory")
    public List<Product> getProductListByCategory(@RequestParam("categoryId") Long categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }

}
