package com.books.shop.dao;

import com.books.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {

    List<Product> findAllByCategoryId(Long categoryId);
}
