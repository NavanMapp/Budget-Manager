package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.dto.UserDTO;
import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.models.User;
import com.mapp.budgetmanager.repository.DepartmentRespository;
import com.mapp.budgetmanager.repository.SiteRepository;
import com.mapp.budgetmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    private final UserRepository userRepo;
    private final SiteRepository siteRepo;
    private final DepartmentRespository deptRepo;

    @Autowired
    public UserService(UserRepository userRepo, SiteRepository siteRepo, DepartmentRespository deptRepo) {
        this.userRepo = userRepo;
        this.siteRepo = siteRepo;
        this.deptRepo = deptRepo;
    }

//method to get user from DB for Authentication
    // Implement microsoft embedded login

    // Method to Add user to DB
    public User addUser(UserDTO dto) {
        User user = new User();
        if (user == null) throw new IllegalArgumentException("User cannot be created ");
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        Site site = siteRepo.findById(dto.getSiteId())
                .orElseThrow(() -> new EntityNotFoundException("The site you are allocating does not exist, try again"));
        user.setSite(site);
        Department dept = deptRepo.findById(dto.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("The department you are allocating cannot be found!"));
        user.setDepartment(dept);
        return userRepo.save(user);
    }

    // method to get/view all Users
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    //method to find user by id/email
    public User findUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //Method to update user email, profile etc
    public User updateUser(Long id, UserDTO dto) {
        return userRepo.findById(id).map(
                userExist -> {
                    userExist.setUsername((dto.getUsername()));
                    userExist.setEmail(dto.getEmail());
                    userExist.setPassword(dto.getPassword());
                    Site site = siteRepo.findById(dto.getSiteId())
                            .orElseThrow(() -> new RuntimeException("Site allocation for this user cannot be updated"));
                    userExist.setSite(site);
                    Department dept = deptRepo.findById(dto.getDepartmentId())
                                    .orElseThrow(() -> new
                                            RuntimeException("Department allocation for this user cannot be updated"));
                    userExist.setDepartment(dept);
                    return userRepo.save(userExist);
                }).orElseThrow(() -> new IllegalArgumentException("User does not exist, try again"));
    }

    //Method to Delete user record
    public boolean deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
