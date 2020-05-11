package com.shop.service.interfaces;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;

import java.util.List;

public interface FilterService {
    List<Product> filterProducts(List<Product> listOfProducts, ProductFilterModel productFilterModel);
}
