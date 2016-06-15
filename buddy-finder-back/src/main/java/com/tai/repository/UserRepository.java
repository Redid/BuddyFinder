package com.tai.repository;


import com.tai.controller.exception.UserNotFoundException;
import com.tai.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by izabella on 23.04.16.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findOneByLogin(@Param("login") String login) throws UserNotFoundException;

    User findOneByLastName(String lastName);

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

    User findOneByFirstName(String firstName);
}
