package ca.loblaw.bff;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")

               .antMatchers("/order-details").permitAll()
               .antMatchers("/allOrders").permitAll()
               .antMatchers("/order/cancel/").permitAll()
               .antMatchers("/order/applyVoucher").permitAll()
/*
               .antMatchers("/order-details").hasAuthority("USER")
               .antMatchers("/allOrders").hasAuthority("USER")
               .antMatchers("/order/cancel/").hasAuthority("ADMIN")
               .antMatchers("/order/applyVoucher").hasAuthority("ADMIN")
*/
               .anyRequest().permitAll()
               .and().oauth2Login().and().cors().and().csrf().disable();

    }
}
