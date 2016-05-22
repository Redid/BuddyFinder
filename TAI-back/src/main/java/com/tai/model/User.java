package com.tai.model;

import com.tai.database.AbstractModel;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by izabella on 23.04.16.
 */
@Document(collection = "User")
public class User extends AbstractModel {
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String email;

    public User(){}

    public User( String login, String password, String email){
        this.setPassword(password);
        this.setLogin(login);
        this.setEmail(email);

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
