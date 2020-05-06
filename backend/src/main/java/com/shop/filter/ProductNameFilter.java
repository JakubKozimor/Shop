package com.shop.filter;

import com.shop.entity.Product;

public class ProductNameFilter implements ProductFilter {

    private final String productName;

    public ProductNameFilter(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean filterProduct(Product product) {
        return product.getName().toLowerCase().contains(productName.toLowerCase());
    }
}
