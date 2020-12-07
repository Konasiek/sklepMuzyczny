package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.UserDTO;
import com.sklepmuzyczny.demo.http.request.LoginForm;
import com.sklepmuzyczny.demo.http.response.JwtResponse;
import com.sklepmuzyczny.demo.jwt.JwtProvider;
import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
        // throws Exception if authentication failed
        System.out.println("am in /login method");
        try {
            System.out.println("am in try");
            System.out.println("loginForm username and pass: "+loginForm.getUsername()+" "+loginForm.getPassword());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

            System.out.println("passed authentication");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generate(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<User> user = userService.findOne(userDetails.getUsername());
            System.out.println("znalazlem usera: "+user);
            return ResponseEntity.ok(new JwtResponse(jwt, user.get().getUsername(), user.get().getEmail(), user.get().getUsername(), user.get().getRoles().toString()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getAllUser() {
        List<User> list = userService.getUsers();
        return list;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
    }

    @PostMapping("user/addUser")
    public User addUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setUserId(userDTO.getUserId());

        userService.addNewUser(user);
        return user;
    }
}
