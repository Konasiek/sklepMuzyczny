package com.sklepmuzyczny.demo.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long customerId;
    private String login;
    private String password;


    public CustomerDTO(Long customerId, String login, String password) {
        this.customerId = customerId;
        this.login = login;
        this.password = password;
    }
}
