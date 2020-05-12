package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
public class FilterServiceImplTests {

    @Test
    public void shouldFilterProducts() {
        //given
        FilterServiceImpl filterService = new FilterServiceImpl();
        List<Product> products = prepareData();
        ProductFilterModel productFilterModel = new ProductFilterModel.ProductFilterModelBuilder()
                .setName("e")
                .setPriceFrom(BigDecimal.valueOf(12))
                .setPriceTo(BigDecimal.valueOf(60))
                .build();
        //when
        List<Product> productWithFiltersList = filterService.filterProducts(products, productFilterModel);
        //then
        assertThat(productWithFiltersList,hasSize(1));
    }

    private List<Product> prepareData() {
        Product book = new Product.ProductBuilder()
                .setName("Witcher book")
                .setDescription("Description of book")
                .setPrice(BigDecimal.valueOf(10))
                .setImageUrl("witcher.jpg")
                .setCategoryId(1L)
                .build();
        Product mug = new Product.ProductBuilder()
                .setName("Mug")
                .setDescription("Description of mug")
                .setPrice(BigDecimal.valueOf(15))
                .setImageUrl("mug.jpg")
                .setCategoryId(2L)
                .build();
        Product mousepad = new Product.ProductBuilder()
                .setName("Mousepad")
                .setDescription("Description of mousepad")
                .setPrice(BigDecimal.valueOf(45))
                .setImageUrl("mousepad.jpg")
                .setCategoryId(3L)
                .build();
        Product laptop = new Product.ProductBuilder()
                .setName("Laptop")
                .setDescription("Description of laptop")
                .setPrice(BigDecimal.valueOf(1500))
                .setImageUrl("laptop.jpg")
                .setCategoryId(5L)
                .build();
        return Arrays.asList(book, mug, mousepad, laptop);
    }
}
