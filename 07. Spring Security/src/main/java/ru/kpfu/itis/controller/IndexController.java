package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

@Controller
public class IndexController {

    @Qualifier("userRepository")
    @Autowired
    UserRepository repository;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/panel")
    public String getPanel() {
        return "panel";
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @RequestMapping(value = "/forbidden")
    public String pnh() {
        return "forbidden";
    }

    @RequestMapping(value = "/add")
    public String add() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername("oleg");
        String hashedPass = passwordEncoder.encode("1234");
        user.setPassword(hashedPass);
        repository.save(user);
        return "redirect:/";
    }

}
