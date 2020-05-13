package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import org.junit.Test;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PageServiceImplTests {

    @Test
    public void shouldPreparePage() {
        //given
        PageServiceImpl pageService = new PageServiceImpl();
        List<Product> products = prepareData();
        ProductFilterModel productFilterModel1 = new ProductFilterModel.ProductFilterModelBuilder()
                .setPage(1)
                .setSize(3)
                .build();
        ProductFilterModel productFilterModel2 = new ProductFilterModel.ProductFilterModelBuilder()
                .setPage(0)
                .setSize(3)
                .build();
        //when
        Page<Product> productPage1 = pageService.preparePage(products, productFilterModel1);
        Page<Product> productPage2 = pageService.preparePage(products, productFilterModel2);
        //then
        assertThat(productPage1.getContent().size(), is(equalTo(1)));
        assertThat(productPage2.getContent().size(), is(equalTo(3)));
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
