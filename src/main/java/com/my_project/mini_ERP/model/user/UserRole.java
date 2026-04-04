package com.my_project.mini_ERP.model.user;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    VENDORS("ROLE_VENDORS");

    private String role;
    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
