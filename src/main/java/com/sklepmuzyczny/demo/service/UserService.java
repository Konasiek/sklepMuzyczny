package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.model.Role;
import com.sklepmuzyczny.demo.repository.UserRepository;
import com.sklepmuzyczny.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@DependsOn("passwordEncoder")
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findOne(String username) {
        return userRepository.findByUsername(username);
    }

    public void addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        Optional<Role> userRole = Optional.ofNullable(roleRepository.findByRole("USER"));

        if (!userRole.isPresent()) {
            Role roleUser = new Role();
            roleUser.setRole("USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(roleUser)));

        } else {
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole.get())));
        }

        userRepository.save(user);
    }

    public List<User> getUsers() {
        List<User> list = (List) userRepository.findAll();
        return list;
    }

    public User getUserById(Long id) {
        User user = (User) userRepository.findById(id).get();
        return user;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUsers = userRepository.findByUsername(username);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));
        return optionalUsers.get();
    }
}
