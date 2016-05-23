package com.tai.database;

import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * Created by izabella on 19.05.16.
 */
public class ReadForUser {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;


    public Iterable<User> searchAll(){
        return userRepository.findAll();
    }

    public List<User> searchAllByLastName(String lastName){ return userRepository.findByLastName(lastName);}
    public User searchOneByLastName(String lastName){ return userRepository.findOneByLastName(lastName);}

    public List<User> searchAllByFirstName(String firstName){ return userRepository.findByFirstName(firstName);}
    public User searchOneByFirstName(String firstName){ return userRepository.findOneByFirstName(firstName);}

    public User searchOneByLogin(String login){ return userRepository.findOneByLogin(login);}
    public User searchOneByEmail(String email){ return userRepository.findOneByEmail(email);}
}
