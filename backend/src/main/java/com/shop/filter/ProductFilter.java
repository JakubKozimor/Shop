package com.shop.filter;

import com.shop.entity.Product;

@FunctionalInterface
public interface ProductFilter {
    boolean filterProduct(Product product);
}
