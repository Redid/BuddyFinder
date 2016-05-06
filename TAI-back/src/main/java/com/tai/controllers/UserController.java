package com.tai.controllers;

import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserRepository studentRepository;

    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login() {
        return 0;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public Object logout() {
        return 0;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register() {
        return 0;
    }

    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public @ResponseBody int getAttr(@PathVariable(value="login") String login) {
        return 0;
    }
}
