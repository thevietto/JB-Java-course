package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.exception.UserNotFoundException;
import ru.kpfu.itis.model.Tweet;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.TweetRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.TweetService;
import ru.kpfu.itis.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @RequestMapping(value = "/users/{id}")
    public String getUserPage(@PathVariable Long id, Model model){
        User user = userRepository.findOne(id);
        if(user == null) {
            throw new UserNotFoundException();
        }
        model.addAttribute("user", user);
        List<Tweet> tweetList = tweetRepository.findByUser(user);
        model.addAttribute("tweets", tweetList);
        return "user";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(){
        return "user-not-found";
    }

}
