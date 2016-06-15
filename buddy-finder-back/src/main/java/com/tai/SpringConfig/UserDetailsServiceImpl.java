package com.tai.SpringConfig;

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
        if(user == null){
            throw new UsernameNotFoundException("User login " + s + " not found");
        }
        return new org.springframework.security.core.userdetails.User(s, "pass", asList(() -> "ROLE_USER"));
    }
}
