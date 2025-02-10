package com.mapp.budgetmanager.dto;

import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.Site;
import org.springframework.stereotype.Component;

@Component
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private Department department;
    private Site site;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Site getSite() { return site; }
    public void setSite(Site site) { this.site = site;}

}
