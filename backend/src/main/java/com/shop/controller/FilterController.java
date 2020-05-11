package com.shop.controller;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import com.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/filter")
public class FilterController {

    ProductService productService;

    @Autowired
    public FilterController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/getProducts")
    public Page<Product> getProductsWithFilters(@RequestBody ProductFilterModel productFilterModel) {
        return productService.getProductsWithFilters(productFilterModel);
    }
}
