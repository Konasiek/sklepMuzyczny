package com.sklepmuzyczny.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.sklepmuzyczny.demo.security.ApplicationUserPermission.*;
import static com.sklepmuzyczny.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/*","/js/*").permitAll()
                .antMatchers("/cart**").hasRole(USER.name())
                .antMatchers(HttpMethod.DELETE, "/category/**").hasAuthority(DELETE_CATEGORY.getPermission())
                .antMatchers(HttpMethod.POST, "/category/**").hasAuthority(ADD_CATEGORY.getPermission())
                .antMatchers(HttpMethod.PUT, "/category/**").hasAuthority(ADD_CATEGORY.getPermission())
                .antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority(DELETE_PRODUCT.getPermission())
                .antMatchers(HttpMethod.GET, "/user").hasAuthority(READ_USER.getPermission())
                .antMatchers(HttpMethod.POST, "/product/**").hasAuthority(ADD_PRODUCT.getPermission())
                .antMatchers(HttpMethod.PUT, "/product/**").hasAuthority(ADD_PRODUCT.getPermission())
                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority(BAN_USER.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/", true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(10))
                    .rememberMeParameter("remmember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    // only enable with crsf disabled
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remmember-me")
                    .logoutSuccessUrl("/login");
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")   // ROLE_ADMIN
//                .build();
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password(passwordEncoder.encode("john"))
//                .roles("USER")   // ROLE_USER
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                admin,
//                john
//        );
//    }
}
