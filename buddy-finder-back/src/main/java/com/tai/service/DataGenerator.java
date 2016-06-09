package com.tai.service;

import com.tai.model.Offer;
import com.tai.model.Timer;
import com.tai.model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by izabella on 23.04.16.
 */
public class DataGenerator {

    private List<User> usersList = new ArrayList<User>();
    private List<Offer> offersList =  new ArrayList<Offer>();
    private List<Timer> timersList =  new ArrayList<Timer>();

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

    public Timer generateTimer(){
        Random rn = new Random();
        long ms = -946771200000L + (Math.abs(rn.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        Random generator = new Random(System.currentTimeMillis());
        LocalTime time = LocalTime.MIN.plusSeconds(generator.nextLong());

        Timer timer = new Timer(randomDate,time,time);
        return timer;
    }
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

    //mock
    public User mock(){
        User mock = new User();
        mock.setLogin("aaa");
        mock.setLastName("b");
        mock.setFirstName("a");
        mock.setEmail("a@op.pl");
        mock.setPassword("aaa");
        return mock;
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
        offer.setAnotherInfo(aI);
        offer.setType(type);
        //offer.addWhen(timer);
        offer.setWhere(place);
        return offer;
    }


    public void generate(){
        for (int i = 0; i < 10; i = i + 1){
            this.timersList.add(generateTimer());
        }
        for (int i = 0; i < 30; i = i + 1){
            this.usersList.add(generateUser());
            this.offersList.add(generateOffer());
        }

        this.usersList.add(mock());

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
    public List<Timer> getTimersList() {
        return timersList;
    }
    public void setTimersList(List<Timer> timersList) {
        this.timersList = timersList;
    }

}
