package com.sena.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.demo.models.User;

@RestController
@RequestMapping("user")
public class UserController {

    private ArrayList<User> users = new ArrayList<User>();

    UserController() {
        this.users.add(new User("1", "Alejo", "alejo@mail.com", 23, "34872347"));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity
                .status(200)
                .body(this.users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {

        for (User user : users) {
            if (user.getId().equals(id)) {
                return ResponseEntity
                        .status(200)
                        .body(user);
            }
        }

        return ResponseEntity
                .status(404)
                .build();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        this.users.add(user);
        return ResponseEntity.status(201).body(user);
    }

}
