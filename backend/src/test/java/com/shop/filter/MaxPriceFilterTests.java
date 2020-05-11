package com.shop.filter;

import com.shop.entity.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MaxPriceFilterTests {

    @Test
    public void shouldFilterProductByMaxPriceAndReturnTrue() {
        //given
        Product product1 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(11))
                .build();
        Product product2 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(10))
                .build();
        ProductFilter maxPriceFilter = new MaxPriceFilter(BigDecimal.valueOf(11));
        //then
        assertTrue(maxPriceFilter.filterProduct(product1));
        assertTrue(maxPriceFilter.filterProduct(product2));
    }

    @Test
    public void shouldFilterProductByMaxPriceAndReturnFalse() {
        //given
        Product product1 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(11.01))
                .build();
        Product product2 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(12))
                .build();
        ProductFilter maxPriceFilter = new MaxPriceFilter(BigDecimal.valueOf(11));
        //then
        assertFalse(maxPriceFilter.filterProduct(product1));
        assertFalse(maxPriceFilter.filterProduct(product2));
    }
}