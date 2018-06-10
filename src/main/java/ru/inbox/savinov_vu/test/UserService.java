package ru.inbox.savinov_vu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
@Transactional
public class UserService {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository repo) {
        this.userRepository = repo;
    }


    public Optional<User> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }


    @Secured("ROLE_USER")
    public void createUser(User user) {
        userRepository.save(user);
    }


    @PreAuthorize("isAuthenticated()")
    public void updateUser(User user) {
        userRepository.save(user);
    }


    @Secured("ROLE_ADMIN")
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
