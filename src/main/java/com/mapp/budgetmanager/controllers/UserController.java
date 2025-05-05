package com.mapp.budgetmanager.controllers;

import com.mapp.budgetmanager.dto.UserDTO;
import com.mapp.budgetmanager.models.User;
import com.mapp.budgetmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserDTO userDTO;

    @Autowired
    public UserController(UserService userService, UserDTO userDTO) {
        this.userService = userService;
        this.userDTO = userDTO;
    }

    // Create a user from interface input
    @PostMapping(value = "/register"
            , consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json"
    )
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDto) {
        User create = userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    // Read/Get all users input
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> user = userService.findAllUsers();
        return ResponseEntity.ok(user);
    }

    // Read/find user by Id
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.findById(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    // Update a user from the interface input
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return ResponseEntity.ok("User details updated successfully");
    }

    // Delete user from interface request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
