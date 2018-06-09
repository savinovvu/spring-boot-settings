package ru.inbox.savinov_vu.websecure;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inbox.savinov_vu.websecure.model.User;



@Service
@Transactional
public class UserService {

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(Integer userId) {
        System.out.println("delete user");
    }


    public void updateUser(User user) {
        System.out.println("Update user");
    }
}
