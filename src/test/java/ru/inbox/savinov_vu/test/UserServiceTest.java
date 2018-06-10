package ru.inbox.savinov_vu.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;

    private Authentication authentication;


    @Before
    public void init() {
        AuthenticationManager authenticationManager =
                this.context.getBean(AuthenticationManager.class);
        this.authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken("admin", "admin123"));
    }


    @After
    public void close() {
        SecurityContextHolder.clearContext();
    }


    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void deleteUserUnauthenticated() {
        userService.deleteUser(3);
    }


    @Test
    public void deleteUserAuthenticated() {
        SecurityContextHolder.getContext().setAuthentication(this.authentication);
        userService.deleteUser(3);
    }
/*
    @Test
    @WithMockUser
    public void createUserWithMockUser() {
        User user = new User();
        user.setName("Yosin");
        user.setEmail("yosin@gmail.com");
        user.setPassword("yosin123");
        userService.createUser(user);
    }*/

/*
*
* @Test
@WithUserDetails
public void createUserWithUserDetails()
{
    ...
}
* */


}