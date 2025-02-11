package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.dto.UserDTO;
import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.models.User;
import com.mapp.budgetmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepo;

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
    public User addUser(UserDTO dto) {
        User user = new User();
        if (user == null) throw new IllegalArgumentException("User cannot be created ");

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setDepartment(dto.getDepartment());
        user.setSite(dto.getSite());

        return userRepo.save(user);
    }

    //Method to update user email, profile etc
    public User updateUser(Long id, UserDTO dto) {
        return userRepo.findById(id).map(
                userExist -> {
                    userExist.setEmail(dto.getEmail());
                    userExist.setPassword(dto.getPassword());
                    userExist.setDepartment(dto.getDepartment());
                    return userRepo.save(userExist);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    //Method to Delete user record
    public void deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        }
        throw new EntityNotFoundException("User not found "+ id);
    }
}
