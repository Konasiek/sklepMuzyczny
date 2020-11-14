package com.sklepmuzyczny.demo.security;

import com.sklepmuzyczny.demo.jwt.JwtConfig;
import com.sklepmuzyczny.demo.jwt.JwtTokenVerifier;
import com.sklepmuzyczny.demo.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.crypto.SecretKey;

import static com.sklepmuzyczny.demo.security.ApplicationUserPermission.*;
import static com.sklepmuzyczny.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConfig (SecretKey secretKey, JwtConfig jwtConfig) {
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/login", "/product", "/logout", "/registration", "/index", "/css/*", "/js/*").permitAll()
                .antMatchers("/cart").hasRole(USER.name())
                .antMatchers(HttpMethod.DELETE, "/category/**").hasAuthority(DELETE_CATEGORY.getPermission())
                .antMatchers(HttpMethod.POST, "/category/**").hasAuthority(ADD_CATEGORY.getPermission())
                .antMatchers(HttpMethod.PUT, "/category/**").hasAuthority(ADD_CATEGORY.getPermission())
                .antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority(DELETE_PRODUCT.getPermission())
                .antMatchers(HttpMethod.GET, "/user").hasAuthority(READ_USER.getPermission())
                .antMatchers(HttpMethod.POST, "/product/**").hasAuthority(ADD_PRODUCT.getPermission())
                .antMatchers(HttpMethod.PUT, "/product/**").hasAuthority(ADD_PRODUCT.getPermission())
                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority(BAN_USER.getPermission())
                .anyRequest()
                .authenticated();
    }
}
