package com.shop.service.interfaces;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PageService {
    Page<Product> preparePage(List<Product> listOfProduct, ProductFilterModel productFilterModel);
}
