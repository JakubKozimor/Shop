package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import com.shop.repository.ProductRepository;
import com.shop.service.interfaces.FilterService;
import com.shop.service.interfaces.PageService;
import com.shop.service.interfaces.ProductService;
import com.shop.service.interfaces.ProductSorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    FilterService filterService;
    ProductSorterService productSorterService;
    PageService pageService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, FilterService filterService, ProductSorterService productSorterService, PageService pageService) {
        this.productRepository = productRepository;
        this.filterService = filterService;
        this.productSorterService = productSorterService;
        this.pageService = pageService;
    }

    @Override
    public Page<Product> getListAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getProductsByCategoryId(Pageable pageable, Long categoryId) {
        return productRepository.findAllByCategoryId(pageable, categoryId);
    }

    @Override
    public Page<Product> getProductsWithFilters(ProductFilterModel productFilterModel) {
        List<Product> listOfAllProduct = productRepository.findAll();
        List<Product> listOfProductWithFilter = filterService.filterProducts(listOfAllProduct, productFilterModel);
        List<Product> listOfProductWithFilterAndSort = productSorterService.sortProducts(listOfProductWithFilter, productFilterModel);
        return pageService.preparePage(listOfProductWithFilterAndSort, productFilterModel);
    }
}
