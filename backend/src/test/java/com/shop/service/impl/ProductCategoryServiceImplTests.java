package com.shop.service.impl;

import com.shop.entity.ProductCategory;
import com.shop.repository.ProductCategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class ProductCategoryServiceImplTests {

    @Mock
    ProductCategoryRepository productCategoryRepository;

    @InjectMocks
    ProductCategoryServiceImpl productCategoryService;

    @Before
    public void init() {
        given(productCategoryRepository.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void shouldGetListAllCategory() {
        //when
        List<ProductCategory> productCategories = productCategoryService.getListAllCategory();
        //then
        assertThat(productCategories, hasSize(3));
    }

    private List<ProductCategory> prepareMockData() {
        ProductCategory books = new ProductCategory("books");
        ProductCategory mugs = new ProductCategory("mugs");
        ProductCategory laptops = new ProductCategory("laptops");
        return Arrays.asList(books, mugs, laptops);
    }
}
