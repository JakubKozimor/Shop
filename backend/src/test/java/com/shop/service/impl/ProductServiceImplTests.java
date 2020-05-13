package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import com.shop.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void shouldGetListAllProducts() {
        //given
        Pageable pageable1 = PageRequest.of(0, 2);
        Pageable pageable2 = PageRequest.of(1, 3);

        given(productRepository.findAll(pageable1))
                .willReturn(prepareMockPage(0, 2));
        given(productRepository.findAll(pageable2))
                .willReturn(prepareMockPage(1, 3));
        //when
        Page<Product> pageProducts1 = productService.getListAllProducts(pageable1);
        Page<Product> pageProducts2 = productService.getListAllProducts(pageable2);
        //then
        assertThat(pageProducts1.getContent().size(), is(equalTo(2)));
        assertThat(pageProducts2.getContent().size(), is(equalTo(1)));
    }

    @Test
    public void shouldGetProductsByCategoryId() {
        //given
        Pageable pageable = PageRequest.of(0, 3);
        given(productRepository.findAllByCategoryId(pageable, 3L))
                .willReturn(prepareMockPageById(0, 3, 3L));
        //when
        Page<Product> pageProductsById = productService.getProductsByCategoryId(pageable, 3L);
        //then
        assertThat(pageProductsById.getContent().size(), is(equalTo(1)));
    }

    private List<Product> prepareMockData() {
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

    private Page<Product> prepareMockPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        int start = page * size;
        int end = Math.min(start + size, prepareMockData().size());
        return new PageImpl<>(prepareMockData().subList(start, end), pageable, prepareMockData().size());
    }

    private Page<Product> prepareMockPageById(int page, int size, Long categoryId) {
        List<Product> productListAfterFilter = prepareMockData().stream()
                .filter(product -> product.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(page, size);
        int start = page * size;
        int end = Math.min(start + size, productListAfterFilter.size());
        return new PageImpl<>(productListAfterFilter.subList(start, end), pageable, productListAfterFilter.size());
    }
}
