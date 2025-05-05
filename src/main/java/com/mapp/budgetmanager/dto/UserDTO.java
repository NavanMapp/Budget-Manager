package com.mapp.budgetmanager.dto;

import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.Site;
import org.springframework.stereotype.Component;

@Component
public class UserDTO {

    private String email;
    private String password;
    private Long departmentId;
    private Long siteId;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Long getDepartment() { return departmentId; }
    public void setDepartment(Long department) { this.departmentId = department; }

    public Long getSiteId() { return siteId; }
    public void setSiteId(Long site) { this.siteId = siteId;}

}
