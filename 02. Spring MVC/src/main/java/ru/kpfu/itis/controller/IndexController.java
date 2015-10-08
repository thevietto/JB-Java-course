package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.User;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getIndexPage(ModelMap map) {
        return "index";
    }

    @RequestMapping("/test")
    public String getTestPage(ModelMap map) {
        User u = new User();
        u.setName("Максим");
        map.addAttribute("user", u);
        return "formtest";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute User user, ModelMap map) {
        map.addAttribute("user", user);
        return "result";
    }

}
