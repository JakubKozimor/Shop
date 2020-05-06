package com.shop.service.interfaces;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import org.springframework.data.domain.Page;

public interface FilterService {

    Page<Product> getProductsWithFilters(ProductFilterModel filter);

}
