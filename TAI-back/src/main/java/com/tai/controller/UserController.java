package com.tai.controller;

import com.tai.controller.exception.AuthenticationException;
import com.tai.controller.exception.LoginNotUniqueException;
import com.tai.controller.exception.UserNotFoundException;
import com.tai.controller.response.LoginResponse;
import com.tai.controller.response.UserInformationResponse;
import com.tai.repository.OfferRepository;
import com.tai.controller.request.LoginRequest;
import com.tai.controller.request.RegisterRequest;
import com.tai.service.ReadForUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tai.model.User;

@RestController
public class UserController {

    @Autowired
    ReadForUser readForUser;

    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {  //TODO: Session
        User loggingUser = readForUser.searchOneByLogin(loginRequest.getLogin());
        LoginResponse loginResponse = null;
        if(loggingUser == null){
            throw new UserNotFoundException(loginRequest.getLogin());
        }
        else{
            if(loggingUser.getPassword().equals(loginRequest.getPassword())){
                loginResponse = new LoginResponse(loggingUser.getId(), "test_token"); //TODO: token from session
            }
            else{
                throw new AuthenticationException("Wrong login/password");
            }
        }

        return loginResponse;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public void logout() {

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody RegisterRequest registerRequest) {
        if(readForUser.searchOneByLogin(registerRequest.getLogin()) != null){
            throw new LoginNotUniqueException();
        }
        else{
            User newUser = new User(registerRequest.getLogin(), registerRequest.getPassword(),
                    registerRequest.getLastname(), registerRequest.getFirstname(), registerRequest.getEmail());
            readForUser.save(newUser);
        }
    }

    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public UserInformationResponse getUserInformation(@PathVariable(value="login") String login) {
        UserInformationResponse userInformationResponse = null;
        User userInformation = readForUser.searchOneByLogin(login);
        if(userInformation != null){
            userInformationResponse = new UserInformationResponse(userInformation.getLogin(),
                    userInformation.getFirstName(), userInformation.getLastName(), userInformation.getEmail());
        }
        else{
            throw new UserNotFoundException(login);
        }
        return userInformationResponse;
    }
}
