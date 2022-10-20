package com.spring.jwt.springJWT.controller;

import com.spring.jwt.springJWT.model.User;
import com.spring.jwt.springJWT.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/add-user")
    public String saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable("id") ObjectId id){
        return service.getUser(id);
    }

    @GetMapping("/get-users")
    public List<User> getUsers(){
        return service.getUsers();
    }





}
