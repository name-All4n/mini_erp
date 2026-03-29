package com.my_project.mini_ERP.model;

import java.math.BigDecimal;

public record DataProductListining(Long id, String name, String description, BigDecimal price, int quantityInStock) {
    public DataProductListining(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantityInStock());
    }
}
