package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UsersController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/all") // /users/all
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @RequestMapping(value = "/add")
    public String addUser(Model model) {
        User user = new User();
        user.setAge(30);
        model.addAttribute("user", user);
        return "add-user";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        userService.addUser(user);

        return "redirect:/users/all";
    }

}
