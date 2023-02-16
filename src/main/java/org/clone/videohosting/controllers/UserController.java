package org.clone.videohosting.controllers;

import java.util.List;

import org.clone.videohosting.entities.User;
import org.clone.videohosting.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    
    private UserService userService;

    @PostMapping("/add-new-user")
    public ResponseEntity<String> addUser(@RequestBody User user) {

        userService.addUser(user);

        return ResponseEntity.ok("User added successfully");

    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable(name = "id") String id, @RequestBody User user) {

        return ResponseEntity.ok(userService.updateUserDetails(id, user));

    }

    @GetMapping("/user/{name}")
    public ResponseEntity<User> getUser(@PathVariable(name = "name") String userName) {
        return ResponseEntity.ok(userService.getUser(userName));
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestHeader(name = "email") String email, @RequestHeader(name = "password") String password) {
        return ResponseEntity.ok(userService.login(email, password));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/user/remove/{id}")
    public ResponseEntity<String> removeUser(@PathVariable(name = "id") String id) {

        userService.removeUser(id);

        return ResponseEntity.ok("User removed successfully");
    }

}
