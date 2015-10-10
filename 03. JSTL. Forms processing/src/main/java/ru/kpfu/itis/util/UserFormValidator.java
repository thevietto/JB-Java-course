package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.User;


public class UserFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            errors.rejectValue("login", "", "логин не может быть пустым");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            errors.rejectValue("name", "", "логин не может быть пустым");
        }
    }
}
