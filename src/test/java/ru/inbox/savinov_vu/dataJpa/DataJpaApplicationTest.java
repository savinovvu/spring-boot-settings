package ru.inbox.savinov_vu.dataJpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import ru.inbox.savinov_vu.dataJpa.order.Order;
import ru.inbox.savinov_vu.dataJpa.security.User;
import ru.inbox.savinov_vu.dataJpa.security.UserRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.data.domain.Sort.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DataJpaApplicationTest {

    @Resource
    private UserRepository userRepository;


    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }


    @Test
    public void findUserById() {
        Optional<User> user = userRepository.findById(1);
        assertNotNull(user.get());
    }


    @Test
    public void createUser() {
        User user = new User("SivaPrasad", "sivaprasad@gmail.com");
        User savedUser = userRepository.save(user);
        User newUser = userRepository.findById(savedUser.getId()).get();
        assertEquals("SivaPrasad", newUser.getName());
        assertEquals("sivaprasad@gmail.com", newUser.getEmail());
    }

    public void orderSelect(){
        Order order1 = new Order(Direction.ASC, "name");
        Order order2 = new Order(Direction.DESC, "id");
        Sort sort = by(order1, order2);
        List<User> all = userRepository.findAll(sort);
    }

    public void pagenatingRequest(){
        int size = 25;
        int page = 0;
        PageRequest pageable = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> content = userPage.getContent();
    }


}