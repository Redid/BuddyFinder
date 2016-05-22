package com.tai.controllers;

import com.tai.database.DataGenerator;
import com.tai.model.Offer;
import com.tai.model.Timer;
import com.tai.model.User;
import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/databaseGeneration")
public class GeneratingDatabase {

    @Autowired
    UserRepository studentRepository;

    @Autowired
    OfferRepository offerRepository;


    private List<User> usersList = new ArrayList<User>();
    private List<Offer> offersList = new ArrayList<Offer>();

    public void generateMockData() {
        DataGenerator d = new DataGenerator();
        d.generate();
        System.out.println("JezusMaria");
        this.usersList.addAll(d.getUsersList());
        this.offersList.addAll(d.getOffersList());
    }

    public void generateDatabaseCollections() {

        generateMockData();



        //dokument dla subjectu
        Random r = new Random();
        int tmp;

        //dokument dla studenta
        for (int i = 0; i < usersList.size(); i = i + 1) {
            usersList.get(i).setEmail(usersList.get(i).getEmail());
            usersList.get(i).setLogin(usersList.get(i).getLogin());
            usersList.get(i).setFirstName(usersList.get(i).getFirstName());
            usersList.get(i).setLastName(usersList.get(i).getLastName());
            usersList.get(i).setPassword(usersList.get(i).getPassword());
            studentRepository.save(usersList.get(i));
        }
        //dokument dla oferty
        for (int i = 0; i < offersList.size(); i = i + 1) {
            offersList.get(i).setWhere(offersList.get(i).getWhere());
            for(Timer timer: offersList.get(i).getWhen()){
                offersList.get(i).addWhen(timer);
            }
            offersList.get(i).setType(offersList.get(i).getType());
            offersList.get(i).setAnotherInfo(offersList.get(i).getAnotherInfo());
            tmp = Math.abs(r.nextInt())+1;
            offersList.get(i).setUser(this.usersList.get(tmp%usersList.size()));
            offerRepository.save(offersList.get(i));
        }
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object getHomePage() {

        generateDatabaseCollections();

        return 0;
    }
}
