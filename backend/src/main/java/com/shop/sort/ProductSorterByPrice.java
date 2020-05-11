package com.shop.sort;

import com.shop.entity.Product;

import java.util.Comparator;
import java.util.List;

public class ProductSorterByPrice implements ProductSorter {
    @Override
    public Comparator<Product> sortProduct(List<Product> listOfProducts, String sortOrder) {
        if (sortOrder.equals("desc"))
            return Comparator.comparing(Product::getPrice).reversed();
        return Comparator.comparing(Product::getPrice);
    }
}
