package com.shop.service.interfaces;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    Page<Product> getListAllProducts(Pageable pageable);

    Page<Product> getProductsByCategoryId(Pageable pageable, Long categoryId);

    Page<Product> getProductsWithFilters(ProductFilterModel filter);
}
