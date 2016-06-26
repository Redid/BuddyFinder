package com.tai.config;

import com.tai.model.User;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Component
public class BuddyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println(authentication);
        Principal principal = null;
        String login = null;
        try {
            Object obj = authentication.getPrincipal();
            if(obj instanceof String) {
                login = (String) authentication.getPrincipal();
            }
            if(obj instanceof Principal) {
                principal = (Principal) authentication.getPrincipal();
                login = principal.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LOGIN: " + login);
        if(login != null) {
            System.out.println(httpServletResponse);
            System.out.println(httpServletRequest);

            User user = userRepository.findOneByLogin(login);
            if(user == null) {
                user = new User();
                user.setLogin(login);
                userRepository.save(user);
            }
        }

        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
    }
}
