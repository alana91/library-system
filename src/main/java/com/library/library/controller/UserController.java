package com.library.library.controller;

import com.library.library.model.User;
import com.library.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        return service.getUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> addUser(@RequestBody User newUser){
        User user = service.addUser(newUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User newUser){
        User updatedUser = service.updateUser(newUser, id);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }
}
