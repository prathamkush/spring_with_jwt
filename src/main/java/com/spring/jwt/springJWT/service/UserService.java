package com.spring.jwt.springJWT.service;

import com.spring.jwt.springJWT.model.User;
import com.spring.jwt.springJWT.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUser(ObjectId id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseGet(optionalUser::get);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public String saveUser(User user){
        userRepository.save(user);
        return "User created successfully";
    }





}
