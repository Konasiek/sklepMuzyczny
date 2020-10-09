package com.sklepmuzyczny.demo.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.sklepmuzyczny.demo.security.ApplicationUserPermission.*;
import static com.sklepmuzyczny.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*","/js/*").permitAll()
                .antMatchers("/cart**").hasRole(USER.name())
                .antMatchers(HttpMethod.DELETE, "/category/**").hasAuthority(DELETE_CATEGORY.name())
                .antMatchers(HttpMethod.POST, "/category/**").hasAuthority(ADD_CATEGORY.name())
                .antMatchers(HttpMethod.PUT, "/category/**").hasAuthority(ADD_CATEGORY.name())
                .antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority(DELETE_PRODUCT.name())
                .antMatchers(HttpMethod.POST, "/product/**").hasAuthority(ADD_PRODUCT.name())
                .antMatchers(HttpMethod.PUT, "/product/**").hasAuthority(ADD_PRODUCT.name())
                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority(BAN_USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
