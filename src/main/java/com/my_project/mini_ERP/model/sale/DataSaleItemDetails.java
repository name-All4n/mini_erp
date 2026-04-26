package com.my_project.mini_ERP.model.sale;

import java.math.BigDecimal;

public record DataSaleItemDetails(
        String productName,
        Integer quantity,
        BigDecimal priceAtSale,
        BigDecimal subtotal
) {
    public DataSaleItemDetails(SaleItem item) {
        this(
                item.getProduct().getName(),
                item.getQuantity(),
                item.getPriceAtSale(),
                item.getPriceAtSale().multiply(BigDecimal.valueOf(item.getQuantity()))
        );
    }
}
