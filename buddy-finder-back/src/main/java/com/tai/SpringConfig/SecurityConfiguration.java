package com.tai.SpringConfig;

import com.tai.SpringConfig.security.RestAuthFailureHandler;
import com.tai.SpringConfig.security.RestAuthSuccessHandler;
import com.tai.SpringConfig.security.RestLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(value = {"com.tai.**.security"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RestAuthSuccessHandler authenticationSuccessHandler;
    @Autowired
    private RestAuthFailureHandler authenticationFailureHandler;
    @Autowired
    private RestLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public void global(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("pass").roles("USER")
                .and()
                .withUser("user2").password("pass").roles("USER");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/", "/register", "/offers/*").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                    .loginProcessingUrl("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .and()
                .csrf().disable()
                .sessionManagement()
                    .maximumSessions(1);
    }
}
