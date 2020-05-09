package com.shop.sort;

import com.shop.entity.Product;

import java.util.Comparator;
import java.util.List;

@FunctionalInterface
public interface ProductSorter {
    Comparator<Product> sortProduct(List<Product> listOfProducts, String sortOrder);
}
