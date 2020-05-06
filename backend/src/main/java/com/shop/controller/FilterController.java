package com.shop.controller;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import com.shop.service.interfaces.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/filter")
public class FilterController {

    FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @PostMapping("/getProducts")
    public Page<Product> getProductsWithFilters(@RequestBody ProductFilterModel productFilterModel) {
        return filterService.getProductsWithFilters(productFilterModel);
    }
}
