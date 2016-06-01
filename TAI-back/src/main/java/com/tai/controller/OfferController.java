package com.tai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tai.service.ReadForOffer;
import com.tai.service.ReadForUser;
import com.tai.model.Offer;
import com.tai.controller.request.EditOfferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/offers")
public class OfferController {

    @Autowired
    ReadForUser readForUser;

    @Autowired
    ReadForOffer readForOffer;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Offer> list() {
        List<Offer> offers = new ArrayList<>();
        readForOffer.searchAll().forEach(offers::add);
        return offers;
    }

    @RequestMapping(value = "/{offerId}", method = RequestMethod.GET)
    public ResponseEntity<Offer> handleOffer(@PathVariable("offerId") String offerId) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        Offer offer = readForOffer.searchById(offerId);
        if(offer != null){
            httpStatus = HttpStatus.FOUND;
        }

        return new ResponseEntity<>(offer, httpStatus);
    }

    @RequestMapping(value = "/{offerId}/edit", method = RequestMethod.PUT)
    public ResponseEntity<String> edit(@PathVariable("offerID") String offerID, @RequestBody String editOfferRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String entityMsg = "Offer with this ID not found";

        try {
            Offer offerToEdit = readForOffer.searchById(offerID);
            if(offerToEdit != null){
                EditOfferRequest newOffer = new ObjectMapper().readValue(editOfferRequest, EditOfferRequest.class);
                offerToEdit.setPreferredSex(newOffer.getPreferredSex());
                offerToEdit.setPreferredAge(newOffer.getPreferredAge());
                offerToEdit.setAnotherInfo(newOffer.getAnotherInfo());
                offerToEdit.setWhere(newOffer.getWhere());
                offerToEdit.setWhen(newOffer.getWhen());

                httpStatus = HttpStatus.OK;
                entityMsg = "Offer found and edited";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<String>(entityMsg, httpStatus);
    }

    @RequestMapping(value = "/{offerId}/remove", method = RequestMethod.DELETE)
    public ResponseEntity<String> remove(@PathVariable("offerID") String offerID) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String entityMsg = "Offer with this ID not found";

        if(readForOffer.searchById(offerID) != null){
//            readForOffer.(offerID); TODO: deleting
            httpStatus = HttpStatus.OK;
            entityMsg = "Offer successfully removed";
        }

        return new ResponseEntity<String>(entityMsg, httpStatus);
    }

    @RequestMapping(value = "/{offerId}/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@PathVariable("offerId") String offerId, @RequestBody String jsonOffer) {
        HttpStatus httpStatus = HttpStatus.FOUND;
        String entityMsg = "OfferID already in database";
        try {
            if(readForOffer.searchById(offerId) != null){
                EditOfferRequest offerRequest = new ObjectMapper().readValue(jsonOffer, EditOfferRequest.class);
                Offer newOffer = new Offer();

                //TODO: User set
                newOffer.setPreferredSex(offerRequest.getPreferredSex());
                newOffer.setPreferredAge(offerRequest.getPreferredAge());
                newOffer.setAnotherInfo(offerRequest.getAnotherInfo());
                newOffer.setWhere(offerRequest.getWhere());
                newOffer.setWhen(offerRequest.getWhen());

                httpStatus = HttpStatus.ACCEPTED;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return new ResponseEntity<String>(entityMsg, httpStatus);
    }
}
