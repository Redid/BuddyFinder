package com.tai.controller;

import com.tai.controller.exception.UserNotFoundException;
import com.tai.controller.request.EditUserRequest;
import com.tai.model.User;
import com.tai.repository.OfferRepository;
import com.tai.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfferRepository offerRepository;


    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());

        User user = userRepository.findOneByLogin(principal.getName());
        if(user != null) {
            map.put("lastName", user.getLastName());
            map.put("firstName", user.getFirstName());
            map.put("email", user.getEmail());
            map.put("sex", user.getSex());
            if(user.getAge() != null) {
                map.put("age", Integer.toString(user.getAge()));
            }
        }
        return map;
    }

    /*
    @RequestMapping(value = "/logout2", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            System.out.println(auth.getName());
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }*/
    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);

    @ResponseStatus(value = HttpStatus.OK, reason = "Edit successful")
    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public void editUserInformation(@RequestBody EditUserRequest editUserRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        System.out.println(login);

        User user = userRepository.findOneByLogin(login);
        if(user == null){
            //create new
            user = new User();
            user.setLogin(login);
        }

        setUserInformation(user, editUserRequest);
        userRepository.save(user);
    }

    private void setUserInformation(User user, EditUserRequest editUserRequest){
        //String login = editUserRequest.getLogin() != null ? editUserRequest.getLogin() : user.getLogin();
        String firstname = editUserRequest.getFirstname() != null ? editUserRequest.getFirstname() : user.getFirstName();
        String lastname = editUserRequest.getLastname() != null ? editUserRequest.getLastname() : user.getLastName();
        String email = editUserRequest.getEmail() != null ? editUserRequest.getEmail() : user.getEmail();
        String sex = editUserRequest.getSex() != null ? editUserRequest.getSex() : user.getSex();
        Integer age = editUserRequest.getAge() != null ? editUserRequest.getAge() : user.getAge();
        //String password = editUserRequest.getPassword() != null ? editUserRequest.getPassword() : user.getPassword();

        //user.setLogin(login);
        System.out.println(firstname);
        System.out.println(lastname);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setSex(sex);
        user.setAge(age);
        //user.setPassword(password);
    }
}