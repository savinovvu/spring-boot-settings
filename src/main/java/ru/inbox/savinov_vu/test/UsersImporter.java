package ru.inbox.savinov_vu.test;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class UsersImporter {

    public List<User> importUsers() throws RuntimeException
    {
        List<User> users = new ArrayList<>();
        //get users by invoking some web service
        //if any exception occurs throw UserImportServiceCommunicationFailure
        //dummy data
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }
}
