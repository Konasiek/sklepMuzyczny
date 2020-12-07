package com.sklepmuzyczny.demo.http.response;


public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String account;
    private String username;
    private String role;


    public JwtResponse(String token, String type, String account, String username, String role) {
        this.token = token;
        this.type = type;
        this.account = account;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
