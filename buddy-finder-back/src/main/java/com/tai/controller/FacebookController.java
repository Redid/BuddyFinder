package com.tai.controller;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/facebook-data")
public class FacebookController {

    @Autowired
    private Facebook facebook;

    @Autowired
    private ConnectionRepository connectionRepository;


    @RequestMapping(method= RequestMethod.GET)
    public Object helloFacebook() {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        return facebook.userOperations().getUserProfile();
    }

}
*/