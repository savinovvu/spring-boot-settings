package ru.inbox.savinov_vu.web;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



@Component
public class UserValidator implements Validator {

    //    @Resourse
    UserRepository repository = new UserRepository();

    @Resource
    private MessageSource messageSource;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String email = user.getEmail();
        User userByEmail = repository.findByEmail(email);
        if (userByEmail != null) {

            String code = "email.exists";
            Object[] args = new Object[]{email};
            String defaultMsg = "Email " + email + " already in use";
            Locale locale = Locale.getDefault();

            String errorMsg = messageSource.getMessage(code, args, defaultMsg, locale);

            errors.rejectValue("email",
                    "email.exists",
                    new Object[]{email},
                    errorMsg);
        }
    }


    /*mock @Repository */
    public static class UserRepository {

        static List<User> users = new ArrayList<>();


        static {
            users.add(new User(1, "nameUser1", "user1@mail.ru", "password1"));
            users.add(new User(2, "nameUser2", "user2@mail.ru", "password2"));
            users.add(new User(3, "nameUser3", "user3@mail.ru", "password3"));
        }

        public User findByEmail(String email) {
            return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
        }

    }
}
