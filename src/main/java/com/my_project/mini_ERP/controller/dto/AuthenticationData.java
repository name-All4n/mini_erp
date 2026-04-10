package com.my_project.mini_ERP.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
