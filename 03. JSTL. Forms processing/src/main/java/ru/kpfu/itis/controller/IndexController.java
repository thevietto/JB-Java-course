package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.util.UserFormValidator;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String getIndexPage(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/save")
    public String saveUser(@ModelAttribute User user, BindingResult result, Model model) {
        UserFormValidator validator = new UserFormValidator();
        validator.validate(user, result);
        if (result.hasErrors()) {
            return "index";
        }
        return "index";
    }

}
