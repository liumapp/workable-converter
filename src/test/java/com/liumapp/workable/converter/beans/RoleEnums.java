package com.liumapp.workable.converter.beans;

public enum RoleEnums {

    FREE_USER("normal"),

    VIP_USER("vip"),

    SUPER_VIP_USER("super_vip");

    private String role;

    RoleEnums(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
