package ru.inbox.savinov_vu.websecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.websecure.model.User;



@RestController
public class AdminRestController {

    @Autowired
    private UserService userService;

//AND, OR, NOT
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER') AND isFullyAuthenticated()")
    @PutMapping("/admin/users/{id}")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }


    @Secured("ROLE_ADMIN")
    @DeleteMapping("/admin/users/{id}")
    public void deleteUser(@PathVariable("id") Integer userId) {
        userService.deleteUser(userId);
    }
}
