package ru.inbox.savinov_vu.jdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateApplicationTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void findAllUsers(){
        List<User> all = userRepository.findAll();
        assertNotNull(all);
        assertTrue(!all.isEmpty());
    }

    @Test
    public void findUserById()  {
        User user = userRepository.findUserById(1);
        assertNotNull(user);
    }
    @Test
    public void createUser() {
        User user = new User(0, "Johnson", "johnson@gmail.com");
        User savedUser = userRepository.create(user);
        User newUser = userRepository.findUserById(savedUser.getId());
        assertNotNull(newUser);
        assertEquals("Johnson", newUser.getName());
        assertEquals("johnson@gmail.com", newUser.getEmail());
    }

}