package ru.kata.spring.boot_security.demo.dao;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao extends UserDetailsService {

    List<User> showUsers();

    User showById(long id);

    void saveUser(User user);

    void update(User user, Long id);

    void delete(Long id);

    User findByUsername(String username);
}
