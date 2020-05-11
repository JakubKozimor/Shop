package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.filter.MaxPriceFilter;
import com.shop.filter.MinPriceFilter;
import com.shop.filter.ProductFilter;
import com.shop.filter.ProductNameFilter;
import com.shop.models.ProductFilterModel;
import com.shop.service.interfaces.FilterService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService {

    @Override
    public List<Product> filterProducts(List<Product> listOfProducts, ProductFilterModel productFilterModel) {
        if (!productFilterModel.getName().equals(""))
            listOfProducts = this.filterByCondition(new ProductNameFilter(productFilterModel.getName()), listOfProducts);

        if (productFilterModel.getPriceFrom() != null)
            listOfProducts = this.filterByCondition(new MinPriceFilter(productFilterModel.getPriceFrom()), listOfProducts);

        if (productFilterModel.getPriceTo() != null && !productFilterModel.getPriceTo().equals(BigDecimal.valueOf(0)))
            listOfProducts = this.filterByCondition(new MaxPriceFilter(productFilterModel.getPriceTo()), listOfProducts);

        return listOfProducts;
    }

    private List<Product> filterByCondition(ProductFilter productFilter, List<Product> listOfProduct) {
        return listOfProduct.stream()
                .filter(productFilter::filterProduct)
                .collect(Collectors.toList());
    }
}
