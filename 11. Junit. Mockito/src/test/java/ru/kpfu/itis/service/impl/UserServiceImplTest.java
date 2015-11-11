package ru.kpfu.itis.service.impl;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.util.UserRegistrationFormToUserTransformer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    UserServiceImpl userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void saveNewUserTest() {
        UserRegistrationForm form = new UserRegistrationForm();
        form.setEmail("a");
        form.setUsername("a");
        form.setPassword("a");
        form.setRepassword("a");

        userService.userRepository = Mockito.mock(UserRepository.class);
        userService.saveNewUser(form);

        Mockito.verify(userService.userRepository).save(Mockito.any(User.class));
    }

    @Test
    public void testss() {
        List list = mock(ArrayList.class);
        when(list.get(0)).thenReturn("YO!");
        when(list.get(1)).thenThrow(new RuntimeException());

        System.out.println(list.get(0));

//        verify(list, times(1)).get(0);
//        any

//        System.out.println(list.size());
//        list.get(1);


    }

}
