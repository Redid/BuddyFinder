package com.tai.controller;

import com.tai.controller.exception.LoginNotUniqueException;
import com.tai.controller.exception.UserNotFoundException;
import com.tai.controller.request.EditUserRequest;
import com.tai.controller.request.RegisterRequest;
import com.tai.model.User;
import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/logout2", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            System.out.println(auth.getName());
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody RegisterRequest registerRequest) {
        if(userRepository.findOneByLogin(registerRequest.getLogin()) != null){
            throw new LoginNotUniqueException();
        }
        else{
            User newUser = new User(registerRequest.getLogin(), registerRequest.getPassword(),
                    registerRequest.getLastname(), registerRequest.getFirstname(), registerRequest.getEmail());
            userRepository.save(newUser);
        }
    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(value = HttpStatus.OK, reason = "Edit successful")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editUserInformation(@RequestBody EditUserRequest editUserRequest){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findOneByLogin(login);
        if(user == null){
            throw new UserNotFoundException("Ups! We have internal problem with logins. Login " + login + " not found");
        }

        setUserInformation(user, editUserRequest);
        userRepository.save(user);
    }

    private void setUserInformation(User user, EditUserRequest editUserRequest){
        String login = editUserRequest.getLogin() != null ? editUserRequest.getLogin() : user.getLogin();
        String firstname = editUserRequest.getFirstname() != null ? editUserRequest.getFirstname() : user.getFirstName();
        String lastname = editUserRequest.getLastname() != null ? editUserRequest.getLastname() : user.getLastName();
        String email = editUserRequest.getEmail() != null ? editUserRequest.getEmail() : user.getEmail();
        String password = editUserRequest.getPassword() != null ? editUserRequest.getPassword() : user.getPassword();

        user.setLogin(login);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
    }
}
