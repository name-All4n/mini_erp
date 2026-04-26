package com.my_project.mini_ERP.model.sale;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DataSaleRegistration(
        @NotNull
        @NotEmpty
        List<@Valid DataItemSale> items) {
}
