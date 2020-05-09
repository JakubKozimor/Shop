package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.models.ProductFilterModel;
import com.shop.service.interfaces.ProductSorterService;
import com.shop.sort.ProductSorterByName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSorterServiceImpl implements ProductSorterService {
    @Override
    public List<Product> sortProducts(List<Product> listOfProducts, ProductFilterModel productFilterModel) {
        if (!productFilterModel.getOrder().equals("") && productFilterModel.getOrder().contains(" ")) {
            String[] orderInstructionsArray = productFilterModel.getOrder().split(" ", 2);
            String orderBy = orderInstructionsArray[0];
            String sortOrder = orderInstructionsArray[1];
            return this.sortByConditions(listOfProducts, orderBy, sortOrder);
        }
        return listOfProducts;
    }

    private List<Product> sortByConditions(List<Product> listOfProducts, String orderBy, String sortOrder) {
        if (orderBy.equals("name"))
            listOfProducts.sort(new ProductSorterByName().sortProduct(listOfProducts, sortOrder));
        return listOfProducts;
    }
}
