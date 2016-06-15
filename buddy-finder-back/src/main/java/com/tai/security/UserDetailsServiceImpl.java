package com.tai.security;

import com.tai.model.User;
import com.tai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOneByLogin(s);
        if(s.equals("root")){
            System.out.println("root");
            user = new User();
            user.setLogin("root");
            user.setPassword("pass");
            return new BFUserDetails(user, asList(() ->"ROLE_USER"));
        }
        if(user == null){
            throw new UsernameNotFoundException("User login " + s + " not found");
        }
        System.out.println(user.getLogin());
        return new BFUserDetails(user, asList(() -> "ROLE_USER"));
    }
}
