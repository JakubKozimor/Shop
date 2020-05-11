package com.shop.filter;

import com.shop.entity.Product;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductNameFilterTests {

    @Test
    public void shouldFilterProductByMaxPriceAndReturnTrue() {
        //given
        Product product = new Product.ProductBuilder()
                .setName("coffee cup")
                .build();
        ProductFilter productNameFilter1 = new ProductNameFilter("cup");
        ProductFilter productNameFilter2 = new ProductNameFilter("e cup");
        //then
        assertTrue(productNameFilter1.filterProduct(product));
        assertTrue(productNameFilter2.filterProduct(product));
    }

    @Test
    public void shouldFilterProductByMaxPriceAndReturnFalse() {
        //given
        Product product = new Product.ProductBuilder()
                .setName("coffee cup")
                .build();
        ProductFilter productNameFilter1 = new ProductNameFilter("coffeecup");
        ProductFilter productNameFilter2 = new ProductNameFilter("coffee cub");
        //then
        assertFalse(productNameFilter1.filterProduct(product));
        assertFalse(productNameFilter2.filterProduct(product));
    }
}
