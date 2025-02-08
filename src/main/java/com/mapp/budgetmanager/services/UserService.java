package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.models.User;
import com.mapp.budgetmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    private final UserRepository userRepo;
    
    @Autowired
    public UserService (UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //method to get user from DB for Authentication
    // Implement microsoft embedded login

    //method to find user by id/email
    public User findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    // method to get/view all Users
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
    // Method to Add user to DB
    public User addUser() {
        User user = new User();
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setDepartment(user.getDepartment());
        return userRepo.save(user);
    }

    //Method to update user email, profile etc
    public User updateUser(Long id) {
        return userRepo.findById(id).map(
                userExist -> {
                    userExist.setName(userExist.getName());
                    userExist.setEmail(userExist.getEmail());
                    userExist.setPassword(userExist.getPassword());
                    userExist.setDepartment(userExist.getDepartment());
                    return userRepo.save(userExist);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    //Method to Delete user record
    public void deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
