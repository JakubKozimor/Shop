package com.shop.service.interfaces;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;

import java.util.List;

public interface ProductSorterService {
    List<Product> sortProducts(List<Product> listOfProducts, ProductFilterModel productFilterModel);
}
