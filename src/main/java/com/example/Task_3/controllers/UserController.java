package com.example.Task_3.controllers;

import com.example.Task_3.models.User;
import com.example.Task_3.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody Map<String, String> body) {
        userService.deleteUserById(body.get("id"));
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUserUsername(@RequestBody Map<String, String> body) {
        String userId = body.get("id");
        String newUsername = body.get("username");

        if (userId == null || newUsername == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "new username must be provided");
        }

        User updatedUser = userService.updateUserUsername(userId, newUsername);
        return ResponseEntity.ok(updatedUser);
    }

}
