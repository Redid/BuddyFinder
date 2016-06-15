package com.tai.controller;

import com.tai.controller.exception.OfferNotFoundException;
import com.tai.controller.request.AddNewOfferRequest;
import com.tai.controller.request.EditOfferRequest;
import com.tai.controller.response.OfferListResponse;
import com.tai.model.Offer;
import com.tai.model.Timer;
import com.tai.model.User;
import com.tai.service.ReadForOffer;
import com.tai.service.ReadForUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public OfferListResponse list() {
        List<Offer> offers = new ArrayList<>();
        readForOffer.searchAll().forEach(offers::add);
        return new OfferListResponse(offers, offers.size());
    }

    @RequestMapping(value = "/{offerId}", method = RequestMethod.GET)
    public Offer handleOffer(@PathVariable("offerId") String offerId) {
        Offer offer = readForOffer.searchById(offerId);
        if(offer == null){
            throw new OfferNotFoundException();
        }

        return offer;
    }

    @RequestMapping(value = "/{offerId}/edit", method = RequestMethod.PUT)
    public void edit(@PathVariable("offerID") String offerID, @RequestBody EditOfferRequest editOfferRequest) {
        Offer offerToEdit = readForOffer.searchById(offerID);
        if(offerToEdit != null){
            offerToEdit.setPreferredSex(editOfferRequest.getPreferredSex());
            offerToEdit.setPreferredAge(editOfferRequest.getPreferredAge());
            offerToEdit.setAnotherInfo(editOfferRequest.getAnotherInfo());
            offerToEdit.setWhere(editOfferRequest.getWhere());
            offerToEdit.setWhen(editOfferRequest.getWhen());
        }
        else{
            throw new OfferNotFoundException();
        }
    }

    @RequestMapping(value = "/{offerId}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("offerID") String offerID) {
        if(readForOffer.searchById(offerID) != null){
            readForOffer.deleteOffer(offerID);
        }
        else{
            throw new OfferNotFoundException();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody AddNewOfferRequest addNewOfferRequest) {
        Offer newOffer = new Offer();

        User owner = readForUser.searchOneByLogin(addNewOfferRequest.getUser());
        newOffer.setUser(owner);
        newOffer.setPreferredSex(addNewOfferRequest.getPreferredSex());
        newOffer.setPreferredAge(addNewOfferRequest.getPreferredAge());
        newOffer.setAnotherInfo(addNewOfferRequest.getAnotherInfo());
        newOffer.setWhere(addNewOfferRequest.getWhere());
        newOffer.setWhen(addNewOfferRequest.getWhen());
    }
}
