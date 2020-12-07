package com.sklepmuzyczny.demo.security;

import com.sklepmuzyczny.demo.jwt.JwtEntryPoint;
import com.sklepmuzyczny.demo.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@DependsOn("passwordEncoder")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtFilter jwtFilter;
    @Autowired
    private JwtEntryPoint accessDenyHandler;
    @Autowired
    private PasswordEncoder passwordEncoder;


    //POBIERANIE WSTEPNYCH DANYCH??
    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);

        System.out.println("usersQuery: " + usersQuery);
        System.out.println("rolesQuery: " + rolesQuery);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/product", "/logout", "/registration", "/index", "/css/*", "/js/*").permitAll()
                .antMatchers("/cart").access("hasAnyRole('USER')")
                .anyRequest().permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(accessDenyHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
//        OLD CONFIGURE !!!
//http
//        .cors().and().csrf().disable()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
//        .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
//        .authorizeRequests()
//        .antMatchers("/", "/login", "/product", "/logout", "/registration", "/index", "/css/*", "/js/*").permitAll()
//        .antMatchers("/cart").hasRole(USER.name())
//        .antMatchers(HttpMethod.DELETE, "/category/**").hasAuthority(DELETE_CATEGORY.getPermission())
//        .antMatchers(HttpMethod.POST, "/category/**").hasAuthority(ADD_CATEGORY.getPermission())
//        .antMatchers(HttpMethod.PUT, "/category/**").hasAuthority(ADD_CATEGORY.getPermission())
//        .antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority(DELETE_PRODUCT.getPermission())
//        .antMatchers(HttpMethod.GET, "/user").hasAuthority(READ_USER.getPermission())
//        .antMatchers(HttpMethod.POST, "/product/**").hasAuthority(ADD_PRODUCT.getPermission())
//        .antMatchers(HttpMethod.PUT, "/product/**").hasAuthority(ADD_PRODUCT.getPermission())
//        .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority(BAN_USER.getPermission())
//        .anyRequest()
//        .authenticated();