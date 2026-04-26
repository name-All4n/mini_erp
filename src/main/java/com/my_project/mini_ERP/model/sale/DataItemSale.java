package com.my_project.mini_ERP.model.sale;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DataItemSale (
        @NotNull
        Long productId,
        @NotNull
        @Positive
        Integer quantity
){
}
