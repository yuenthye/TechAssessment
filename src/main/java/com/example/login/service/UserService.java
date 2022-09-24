package com.example.login.service;


import com.example.login.repository.entity.User;

import java.util.List;


public interface UserService {

    List<User> all();

    User findById(Long userid);

    User findByIdName( String username );

}
