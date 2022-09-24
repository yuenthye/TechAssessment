package com.example.login.repository.entity;

import com.example.login.controller.dto.*;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String username;

    private String name;

    private String role;


    public User(UserDto userDto) {

        this.userid = userDto.getUserid();
        this.username = userDto.getUsername();
        this.name = userDto.getName();
         this.role = userDto.getRole();
    }


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


