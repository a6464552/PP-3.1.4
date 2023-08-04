package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao, UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showUsers() {
        return userRepository.findAll();
    }

    @Override
    public User showById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setRoles(user.getRoles());
        userRepository.save(user);
    }

    @Override
    public void update(User user, Long id) {
        User currentUser = userRepository.getById(id);
        currentUser.setUsername(user.getUsername());
        currentUser.setAge(user.getAge());
        currentUser.setRoles(user.getRoles());
        userRepository.save(currentUser);
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not found!", name));
        }
        return user;
    }
}
