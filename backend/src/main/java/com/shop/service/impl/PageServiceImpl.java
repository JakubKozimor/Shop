package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import com.shop.service.interfaces.PageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Override
    public Page<Product> preparePage(List<Product> listOfProduct, ProductFilterModel productFilterModel) {
        Pageable pageable = PageRequest.of(productFilterModel.getPage(), productFilterModel.getSize());
        int start = productFilterModel.getPage() * productFilterModel.getSize();
        int end = Math.min(start + productFilterModel.getSize(), listOfProduct.size());
        return new PageImpl<>(listOfProduct.subList(start, end),pageable,listOfProduct.size());
    }
}
