package com.sklepmuzyczny.demo.DTO;


import com.sklepmuzyczny.demo.model.Role;


import java.util.Set;

public class CustomerDTO {

    private Long customerId;
    private String login;
    private String password;
    private Set<Role> roles;

    public CustomerDTO(Long customerId, String login, String password, Set<Role> roles) {
        this.customerId = customerId;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
