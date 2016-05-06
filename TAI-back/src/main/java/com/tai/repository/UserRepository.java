package com.tai.repository;


import com.tai.database.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by izabella on 23.04.16.
 */
public interface UserRepository extends CrudRepository<User, String> {
    User findOneByLogin(String login);

    User findOneByPassword(String password);

    User findOneByLastName(String lastName);

    List<User> findByLastName(String lastName);

    User findOneByEmail(String email);

    List<User> findByFirstName(String firstName);

    User findOneByFirstName(String firstName);
}
