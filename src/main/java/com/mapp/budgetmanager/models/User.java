package com.mapp.budgetmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "site_id", nullable = false)
    @JsonBackReference
    private Site site;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Dashboard> dashboards;

    public User(Long id, String username, String email, String password, Department department,
                Site site, List<Dashboard> dashboards) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.department = department;
        this.site = site;
        this.dashboards = dashboards;
    }

    public User() {}

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Department getDepartment() { return department; }
    public Site getSite() { return site; }
    public List<Dashboard> getDashboards() { return dashboards; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setDepartment(Department department) { this.department = department; }
    public void setSite(Site site) { this.site = site; }
    public void setDashboards(List<Dashboard> dashboards) { this.dashboards = dashboards; }
}
