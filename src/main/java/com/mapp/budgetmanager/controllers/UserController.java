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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a user from interface input
    @PostMapping(value = "/register"
            , consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json"
    )
    public ResponseEntity<User> addUser(@RequestBody UserDTO dto) {
        User create = userService.addUser(dto);
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
        User user = userService.findUserById(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    // Update a user from the interface input
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updated = userService.updateUser(id, userDTO);
        if (updated != null) return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("User details updated successfully");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Error encountered upon updating user details");
    }

    // Delete user from interface request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("User deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Error encountered when deleting user");
    }
}
