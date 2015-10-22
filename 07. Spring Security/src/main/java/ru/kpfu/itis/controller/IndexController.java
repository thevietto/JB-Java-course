package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

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

}
