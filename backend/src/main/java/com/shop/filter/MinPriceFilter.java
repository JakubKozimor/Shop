package com.shop.filter;

import com.shop.entity.Product;

import java.math.BigDecimal;

public class MinPriceFilter implements ProductFilter {

    private final BigDecimal minPrice;

    public MinPriceFilter(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public boolean filterProduct(Product product) {
        int isGreater = product.getPrice().compareTo(this.minPrice);
        return isGreater >= 0;
    }
}
