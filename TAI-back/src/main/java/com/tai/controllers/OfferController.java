package com.tai.controllers;

import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OfferController {

    @Autowired
    UserRepository studentRepository;

    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/offers/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        return 0;
    }

    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    @ResponseBody
    public Object offer() {
        return 0;
    }

    @RequestMapping(value = "/offers/{offerId}/edit", method = RequestMethod.PUT)
    @ResponseBody
    public Object edit() {
        return 0;
    }

    @RequestMapping(value = "/offers/{offerId}/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public Object remove() {
        return 0;
    }

    @RequestMapping(value = "/offers/{offerId}/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add() {
        return 0;
    }
}
