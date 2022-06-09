package com.springboot.springboot.controllers;

import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        final Optional<User> byId = this.userRepository.findById(id);
        return byId.orElse(null);

    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> lis(){
        return this.userRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public List<User> lis(@PathVariable("id") Long id){
        return this.userRepository.findByIdGreaterThan(id);
    }


}
