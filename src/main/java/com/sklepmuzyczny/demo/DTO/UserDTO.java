package com.sklepmuzyczny.demo.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long userId;

    private String login;
    private String password;


    public UserDTO(Long userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }
}
