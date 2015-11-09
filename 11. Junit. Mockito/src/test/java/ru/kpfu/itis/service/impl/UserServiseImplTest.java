package ru.kpfu.itis.service.impl;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

public class UserServiseImplTest {

    UserServiceImpl userService = new UserServiceImpl();

    @Before
    public void setUp() {
        userService.userRepository = Mockito.mock(UserRepository.class);
        User user = new User();
        user.setEmail("dvAAAAsv");
        Mockito.when(userService.userRepository.findOneByUsername("a")).thenReturn(user);
    }

    @Test
    public void test() {
        System.out.println(userService.userRepository.findOneByUsername("a").getEmail());
    }

}
