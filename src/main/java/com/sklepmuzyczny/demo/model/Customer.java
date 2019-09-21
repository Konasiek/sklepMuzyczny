package com.sklepmuzyczny.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Size(max = 30)
    private String customerName;

    @Email
    private String email;


    @NotBlank
    private String login;

    @JsonIgnore
    private int active;

    @JsonIgnore
    @Length(min = 5, message = "*Twoje hasło musi mieć przynajmniej 5 znaków, 666")
    @NotBlank(message = "*Please provide your password")
    private String password;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_role", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne
    private Delivery delivery;

    public Customer() {
    }

    public Customer(@Size(max = 30) String customerName, @Email String email, @NotBlank String login, int active, @Length(min = 5, message = "*Twoje hasło musi mieć przynajmniej 5 znaków") @NotBlank(message = "*Please provide your password") String password, Set<Role> roles, Delivery delivery) {
        this.customerName = customerName;
        this.email = email;
        this.login = login;
        this.active = active;
        this.password = password;
        this.roles = roles;
        this.delivery = delivery;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
