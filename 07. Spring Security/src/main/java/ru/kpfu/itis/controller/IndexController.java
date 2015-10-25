package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.exception.AccessDenyException;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.enums.UserRole;
import ru.kpfu.itis.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/panel")
    public String getPanel() {
        return "panel";
    }

    @RequestMapping(value = "/forbidden")
    public String getForbiddenPage() {
        return "forbidden";
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") UserRegistrationForm form) {
        userService.saveNewUser(form);
        return "redirect:/";
    }

    @RequestMapping(value = "/abc")
    public String abc() {
//        if (true/*Какое-то условие*/) {
//            throw new AccessDenyException();
//        }
        userService.securedMethod();
        return "index";
    }


    @ExceptionHandler(AccessDenyException.class)
    public String accesDeny() {
        return "access-deny";
    }


}
