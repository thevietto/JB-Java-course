package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.service.StudentService;

@Controller
public class IndexController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        studentService.debugThis();
        return "index";
    }

}
