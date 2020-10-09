package com.sklepmuzyczny.demo.security;

import com.google.common.collect.Sets;
import java.util.Set;

import static com.sklepmuzyczny.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(BUY_PRODUCT, READ_CART)),
    ADMIN(Sets.newHashSet(ADD_CATEGORY, DELETE_CATEGORY, BAN_USER, ADD_PRODUCT, DELETE_PRODUCT)),
    ;

   private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
