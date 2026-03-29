package com.my_project.mini_ERP.model;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DatraProductUpdate(@NotNull Long id, String name, String description, BigDecimal price, int quantityInStock) {
}
