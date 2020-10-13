package com.sklepmuzyczny.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.sklepmuzyczny.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(BUY_PRODUCT, READ_CART)),
    ADMIN(Sets.newHashSet(ADD_CATEGORY, DELETE_CATEGORY, BAN_USER, READ_USER, ADD_PRODUCT, DELETE_PRODUCT)),
    ;

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {

        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(c -> new SimpleGrantedAuthority(c.getPermission()))
                .collect(Collectors.toSet());                                    // changes ApplicationUserPermission to SimpleGrantedAuthority
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name())); // changes ex. "ADMIN" to "ROLE_ADMIN"
        return permissions;
    }
}
