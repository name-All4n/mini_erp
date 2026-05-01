package com.my_project.mini_ERP.model.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DataSaleDetails(
        Long id,
        LocalDateTime saleDate,
        BigDecimal totalValue,
        List<DataSaleItemDetails> items
) {
    public DataSaleDetails(Sale sale) {
        this(
                sale.getId(),
                sale.getSaleDate(),
                sale.getTotalValue(),
                sale.getItems().stream().map(DataSaleItemDetails::new).toList()
        );
    }
}
