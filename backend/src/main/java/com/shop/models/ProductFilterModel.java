package com.shop.models;

import java.math.BigDecimal;

public class ProductFilterModel {

    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private String name;
    private String order;
    private Long categoryId;
    private int page;
    private int size;

    private ProductFilterModel(BigDecimal priceFrom, BigDecimal priceTo, String name, String order, Long categoryId, int page, int size) {
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.name = name;
        this.order = order;
        this.categoryId = categoryId;
        this.page = page;
        this.size = size;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public static class ProductFilterModelBuilder {
        private BigDecimal priceFrom;
        private BigDecimal priceTo;
        private String name;
        private String order;
        private Long categoryId;
        private int page;
        private int size;

        public ProductFilterModelBuilder setPriceFrom(BigDecimal priceFrom) {
            this.priceFrom = priceFrom;
            return this;
        }

        public ProductFilterModelBuilder setPriceTo(BigDecimal priceTo) {
            this.priceTo = priceTo;
            return this;
        }

        public ProductFilterModelBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductFilterModelBuilder setOrder(String order) {
            this.order = order;
            return this;
        }

        public ProductFilterModelBuilder setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductFilterModelBuilder setPage(int page) {
            this.page = page;
            return this;
        }

        public ProductFilterModelBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public ProductFilterModel build() {
            return new ProductFilterModel(priceFrom, priceTo, name, order, categoryId, page, size);
        }
    }
}
