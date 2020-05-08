package com.shop.filter;

import com.shop.entity.Product;

import java.math.BigDecimal;

public class MaxPriceFilter implements ProductFilter {

    private final BigDecimal maxPrice;

    public MaxPriceFilter(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean filterProduct(Product product) {
        int isLower = product.getPrice().compareTo(this.maxPrice);
        return isLower <= 0;
    }
}