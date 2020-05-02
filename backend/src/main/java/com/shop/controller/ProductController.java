package com.shop.controller;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


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
    public Page<Product> getListAllProducts(@RequestParam("page") int page,
                                            @RequestParam("size") int size) {
        return productService.getListAllProducts(PageRequest.of(page, size));
    }

    @GetMapping("/productsByCategory")
    public Page<Product> getProductListByCategory(@RequestParam("page") int page,
                                                  @RequestParam("size") int size,
                                                  @RequestParam("categoryId") Long categoryId) {
        return productService.getProductsByCategoryId(PageRequest.of(page, size), categoryId);
    }

}
