package com.example.login.service;

import com.example.login.repository.UserRepository;
import com.example.login.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceMySQL implements UserService{

    private final UserRepository userRepository;

    public UserServiceMySQL(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> all(){
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result :: add);
        return result;
    }

    @Override
    public User findById (Long userid){
        Optional<User> user = userRepository.findById(userid);
        User userResponse = user.get();

        return userResponse;
    }

    @Override
    public User findByIdName (String username){
        Optional<User> user = userRepository.findByIdName(username);
        User userResponse = user.get();

        return userResponse;
    }


}
