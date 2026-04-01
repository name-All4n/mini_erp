package com.my_project.mini_ERP.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DataProductUpdate(
        @NotNull(message = "O ID é obrigatório para atualização")
        Long id,
        String name,
        String description,
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal price,
        @PositiveOrZero(message = "A quantidade não pode ser negativa")
        Integer quantityInStock) {
}
