package com.spring.jwt.springJWT.controller;

import com.spring.jwt.springJWT.model.User;
import com.spring.jwt.springJWT.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping(value = "/add-user")
    public String saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/get-user")
    public User getUser(HttpServletRequest request){
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return service.getUser(userId);
    }

    @GetMapping("/get-users")
    public List<User> getUsers(HttpServletRequest request){
        return service.getUsers();
    }





}
