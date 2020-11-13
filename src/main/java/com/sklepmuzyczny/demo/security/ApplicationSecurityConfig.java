package com.sklepmuzyczny.demo.security;

import com.sklepmuzyczny.demo.jwt.JwtUsernameAndPasswordAutheticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.sklepmuzyczny.demo.security.ApplicationUserPermission.*;
import static com.sklepmuzyczny.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAutheticationFilter(authenticationManager()))
                .authorizeRequests()
                .antMatchers("/", "/product", "/logout", "/registration", "/index", "/css/*", "/js/*").permitAll()
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
