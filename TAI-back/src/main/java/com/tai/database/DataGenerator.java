package com.tai.database;

import com.tai.model.Offer;
import com.tai.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by izabella on 23.04.16.
 */
public class DataGenerator {

    private List<User> usersList = new ArrayList<User>();
    private List<Offer> offersList =  new ArrayList<Offer>();

    public DataGenerator(){

    }

    private String[] loginA = {
            "da", "adam", "babe", "bibi", "ali", "gda", "tran", "pran", "eca", "ewa", "huh", "uch", "musl", "wials", "blis", "aszli", "poszq", "lal"
    };

    private String[] lastNamesA = {
            "Pujols", "Edmonds", "Hamilton", "Trout", "Gonzalez", "Fielder", "Strasburg", "Bautista"
    };

    private String[] firstNameA = {
            "Noah",	"Emma", "Liam", "Olivia", "Mason","Sophia", "Jacob","Isabella" ,"Ava","Ethan","Mia","Michael", "Emily",
            "Alexander", "Abigail", "James" ,"Madison", "Daniel", "Charlotte"
    };


    private String[] emailA = {
            "fdsdfjd@gmail.com", "dsgjd@gmail.com", "puyotr@gmail.com" , "fdssad@onet.com", "aaaa@gmail.com", "fada@interia.com", "dfsfhs@interia.com",
            "jakismail@onet.pl", "dlp@op.pl", "jakis@gmail.com", "iza@hotmail.com", "mis2433@interia.pl", "szlos@aol.com"
    };

    private String[] typesA = {
            "Date", "Game", "Party", "Custom"
    };

    private String[] placesA = {
            "Kraków", "Zakopane", "Las Vegas", "New York", "Rome", "Alicante", "Kijów", "Berlin", "Bleble", "San Jose", "Siem Reap", "Limon"
    };
    //studnet
    public User generateUser(){

        Random rn = new Random();
        int i = Math.abs(rn.nextInt());
        long indexNumber = Math.abs(rn.nextLong());
        String firstName = firstNameA[i%(this.firstNameA.length)];
        String lastName = lastNamesA[i%(this.lastNamesA.length)];
        String login = loginA[i%(this.loginA.length)];
        String password = login + firstName + lastName;
        String email= emailA[i%(this.emailA.length)];
        User user = new User();
        user.setLogin(login);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    //oferta
    public Offer generateOffer(){
        Offer offer = new Offer();
        Random rn = new Random();
        int i = Math.abs(rn.nextInt());
        String type = typesA[i%(this.typesA.length)];
        i = Math.abs(rn.nextInt());
        String place = placesA[i%(this.placesA.length)];
        String aI = "dodatkowe info, poki co puste";
        long ms = -946771200000L + (Math.abs(rn.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        Date dt = new Date(ms);
        offer.setAnotherInfo(aI);
        offer.setType(type);
        offer.setWhen(dt);
        offer.setWhere(place);
        return offer;
    }


    public void generate(){
        for (int i = 0; i < 30; i = i + 1){
            this.usersList.add(generateUser());
            this.offersList.add(generateOffer());
        }

    }


    public List<User> getUsersList() {
        return usersList;
    }
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
    public List<Offer> getOffersList() {
        return offersList;
    }
    public void setOffersList(List<Offer> offersList) {
        this.offersList = offersList;
    }

}
