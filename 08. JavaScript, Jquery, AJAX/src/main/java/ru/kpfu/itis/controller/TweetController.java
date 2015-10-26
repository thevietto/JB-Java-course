package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.TweetService;
import ru.kpfu.itis.service.UserService;

@Controller
public class TweetController {

    @Autowired
    TweetService tweetService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/tweets/all")
    public String getAllTweetsPage(Model model) {
        model.addAttribute("tweets", tweetService.getAll());
        return "tweets";
    }

    @RequestMapping(value = "/tweets/add")
    @ResponseStatus(value = HttpStatus.OK)
    public void addTweet(@RequestParam("text") String text, @RequestParam("user") Long userId) {
        User user = userRepository.findOne(userId);
        tweetService.addTweet(user, text);
    }

}
