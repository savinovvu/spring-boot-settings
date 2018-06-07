package ru.inbox.savinov_vu.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.inbox.savinov_vu.mybatis.mappers.UserMapper;
import ru.inbox.savinov_vu.utils.domain.User;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisApplicationTest {

    @Resource
    private UserMapper userMapper;


    @Test
    public void findAllUsers()  {
        List<User> users = userMapper.findAllUsers();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }
    @Test
    public void findUserById()  {
        User user = userMapper.findUserById(1);
        assertNotNull(user);
    }
    @Test
    public void createUser() {
        User user = new User(0, "george", "george@gmail.com");
        userMapper.insertUser(user);
        User newUser = userMapper.findUserById(user.getId());
        assertEquals("george", newUser.getName());
        assertEquals("george@gmail.com", newUser.getEmail());
    }
}