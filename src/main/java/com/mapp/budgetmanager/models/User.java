package com.mapp.budgetmanager.models;

import jakarta.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String type;
    private String status;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
}
