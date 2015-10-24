package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.exception.NotFoundException;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.CustomService;

@Controller
public class IndexController {

    @Qualifier("userRepository")
    @Autowired
    UserRepository repository;

    @Autowired
    CustomService service;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        service.method();
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

    @RequestMapping(value = "/add_user")
    public String addUser() {
        throw new NotFoundException();
//        User user = new User();
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode("12345"));
//        user.setUsername("oleg");
//        repository.save(user);
//        return "redirect:/";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "forbidden";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String excep() {
        return "forbidden";
    }

}
