package com.shop.filter;

import com.shop.entity.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinPriceFilterTests {

    @Test
    public void shouldFilterProductByMinPriceAndReturnTrue() {
        //given
        Product product1 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(11))
                .build();
        Product product2 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(10))
                .build();
        MinPriceFilter minPriceFilter = new MinPriceFilter(BigDecimal.valueOf(10));
        //then
        assertTrue(minPriceFilter.filterProduct(product1));
        assertTrue(minPriceFilter.filterProduct(product2));
    }

    @Test
    public void shouldFilterProductByMinPriceAndReturnFalse() {
        //given
        Product product1 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(9.99))
                .build();
        Product product2 = new Product.ProductBuilder()
                .setPrice(BigDecimal.valueOf(9))
                .build();
        MinPriceFilter minPriceFilter = new MinPriceFilter(BigDecimal.valueOf(10));
        //then
        assertFalse(minPriceFilter.filterProduct(product1));
        assertFalse(minPriceFilter.filterProduct(product2));
    }
}
