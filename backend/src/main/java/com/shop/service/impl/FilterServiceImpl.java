package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.filter.MinPriceFilter;
import com.shop.filter.ProductFilter;
import com.shop.filter.ProductNameFilter;
import com.shop.models.ProductFilterModel;
import com.shop.repository.ProductRepository;
import com.shop.service.interfaces.FilterService;
import com.shop.service.interfaces.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService {

    ProductRepository productRepository;
    PageService pageService;

    @Autowired
    public FilterServiceImpl(ProductRepository productRepository, PageService pageService) {
        this.productRepository = productRepository;
        this.pageService = pageService;
    }

    @Override
    public Page<Product> getProductsWithFilters(ProductFilterModel productFilterModel) {
        List<Product> listOfAllProduct = productRepository.findAll();
        List<Product> listOfProductWithFilter = this.filterProducts(listOfAllProduct, productFilterModel);
        return pageService.preparePage(listOfProductWithFilter, productFilterModel);
    }

    private List<Product> filterProducts(List<Product> listOfProducts, ProductFilterModel productFilterModel) {
        if (!productFilterModel.getName().equals(""))
            listOfProducts = this.filterByCondition(new ProductNameFilter(productFilterModel.getName()), listOfProducts);

        if(productFilterModel.getPriceFrom() != null)
            listOfProducts = this.filterByCondition(new MinPriceFilter(productFilterModel.getPriceFrom()), listOfProducts);

        return listOfProducts;
    }

    private List<Product> filterByCondition(ProductFilter productFilter, List<Product> listOfProduct) {
        return listOfProduct.stream()
                .filter(productFilter::filterProduct)
                .collect(Collectors.toList());
    }
}
