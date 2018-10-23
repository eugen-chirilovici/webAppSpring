package com.springapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Mila Bezaliuc").password("endava").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Petru Covaliov").password("endava").roles("USER");
        auth.inMemoryAuthentication().withUser("Maxim Ustimov").password("endava").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
//                .antMatchers("/allusers").access("hasRole('USER') and hasRole('ADMIN')")
                .antMatchers("/allusers").permitAll()
                .antMatchers("/allusers/{gender}/**").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error");
    }
}
