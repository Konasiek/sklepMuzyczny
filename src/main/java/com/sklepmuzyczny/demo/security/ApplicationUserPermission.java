package com.sklepmuzyczny.demo.security;

public enum ApplicationUserPermission {

    // FOR EVERYONE:
    // READ_PRODUCT
    // CREATE_USER
    // READ_CATEGORY

    // FOR LOGGED USER:
    BUY_PRODUCT("buy:product"),
    READ_CART("read:cart"),

    // FOR ADMIN:
    READ_USER("read:user"),
    BAN_USER("ban:user"),
    ADD_PRODUCT("add:product"),
    DELETE_PRODUCT("delete:product"),
    ADD_CATEGORY("add:category"),
    DELETE_CATEGORY("delete:category");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
