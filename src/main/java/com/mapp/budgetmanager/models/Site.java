package com.mapp.budgetmanager.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    public Site() { this.id = id; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Department> getDepartments() { return departments; }

    public void setDepartments(List<Department> departments) { this.departments = departments; }
    public void setName(String name) { this.name = name; }
    public void setId(Long id) { this.id = id; }
}
