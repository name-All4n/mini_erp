package com.my_project.mini_ERP.model;

import java.math.BigDecimal;

public record DataProductRegister(String name, String description, BigDecimal price, int quantityInStock) {
}
