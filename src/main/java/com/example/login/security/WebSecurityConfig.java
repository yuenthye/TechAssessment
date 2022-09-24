package com.example.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        try {
            auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select username, password, enabled from user where username=?")
                    .authoritiesByUsernameQuery("select username, role  from user where username=?")
            ;

//            System.out.println("Completed");
        }
        catch (Exception e)
        {
            System.out.println("Error Occur " + e);
        }
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.formLogin().loginPage("/login");


        http.formLogin()
                .defaultSuccessUrl("/default");

        http.logout()
                .logoutSuccessUrl("/login");

        http.authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/restricted/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/")
                .and()
                .logout().permitAll();


        return http.build();
    }


}
