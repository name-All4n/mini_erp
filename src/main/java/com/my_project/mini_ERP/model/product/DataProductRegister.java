package com.my_project.mini_ERP.model.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DataProductRegister(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotBlank(message = "A descrição é obrigatório")
        String description,
        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal price,
        @PositiveOrZero(message = "A quantidade não pode ser negativa")
        int quantityInStock) {
}
