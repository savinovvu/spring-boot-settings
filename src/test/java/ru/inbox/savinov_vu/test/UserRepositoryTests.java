package ru.inbox.savinov_vu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests
{
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindByEmail() {
        User user = userRepository.findById(1).get();
        assertNotNull(user);
        assertEquals(1, user.getId().intValue());
        assertEquals("admin", user.getName());
    }
}
