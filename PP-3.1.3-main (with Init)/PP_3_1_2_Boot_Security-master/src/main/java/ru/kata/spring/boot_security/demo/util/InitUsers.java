package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitUsers {
    private final RoleService roleService;
    private final UserService userService;

    final Role role_admin = new Role("ROLE_ADMIN");
    final Role role_user = new Role("ROLE_USER");

    @Autowired
    public InitUsers(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    public List<Role> roleAdmin() {
        List<Role> roles = new ArrayList<>();
        roles.add(role_admin);
        return roles;
    }

    public List<Role> roleUser() {
        List<Role> roles = new ArrayList<>();
        roles.add(role_user);
        return roles;
    }
    @Transactional
    @Bean
    public void init() {
        roleService.save(role_admin);
        roleService.save(role_user);
        userService.saveUser(new User("admin", 35, "admin", roleAdmin()));
        userService.saveUser(new User("user", 30, "user", roleUser()));
    }
}
