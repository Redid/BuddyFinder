package com.tai.controllers;

import com.tai.model.Offer;
import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OfferController {

    @Autowired
    UserRepository studentRepository;

    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/offers/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Offer> list() {
        List<Offer> offers = new ArrayList<>();
        offerRepository.findAll().forEach(offer -> offers.add(offer));
        return offers;
    }

    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    @ResponseBody
    public Offer offer(@PathVariable("offerId") String offerId) {
        return offerRepository.findOne(offerId);
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
    public ResponseEntity<String> add(@PathVariable("offerId") String offerId, @RequestBody Offer offer) {
        HttpStatus httpStatus = HttpStatus.FOUND;
        String entityMsg = "OfferID already in database";

        if(offerRepository.findOne(offerId) != null){
            httpStatus = HttpStatus.ACCEPTED;
            entityMsg = "Add offer was accepted, but not added";


        }

        return new ResponseEntity<String>(entityMsg, httpStatus);
    }
}
