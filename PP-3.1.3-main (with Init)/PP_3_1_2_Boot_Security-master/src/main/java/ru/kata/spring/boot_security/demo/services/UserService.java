package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> showUsers();

    User showById(long id);

    void saveUser(User user);

    void update(User user, Long id);

    void delete(Long id);

    User findByUsername(String username);
}
