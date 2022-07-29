package com.google.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
               .antMatchers("/user").hasAuthority("ROLE_USER")
               .antMatchers("/getEmail").hasAuthority("ROLE_ADMIN")
               .antMatchers("/deleteOrder").hasRole("ADMIN")
               .antMatchers("/deleteCustomer").hasAuthority("ROLE_ADMIN")
               .antMatchers("/getCustomers").hasAuthority("ROLE_USER")

/*
               .antMatchers("/getOrderDetailsByOrderID").hasAuthority("USER")
               .antMatchers("/searchOrderAll").hasAuthority("USER")
               .antMatchers("/cancelOrderById").hasAuthority("ADMIN")
               .antMatchers("/applyVoucherToOrder").hasAuthority("ADMIN")
*/

               .anyRequest().permitAll()
               .and().oauth2Login().and().cors().and().csrf().disable();

    }
}
