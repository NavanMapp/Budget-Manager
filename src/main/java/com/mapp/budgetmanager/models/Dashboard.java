package com.mapp.budgetmanager.models;

public class Dashboard {

    private Long id;
    private Department department;
    private String category;
    private String status;
    private String type;
    private float cost;
    private User user;

    public Dashboard(Long id, Department department, String category, String status,
                     String type, float cost, User user) {
        this.id = id;
        this.department = department;
        this.category = category;
        this.status = status;
        this.type = type;
        this.cost = cost;
        this.user = user;
    }

    public Long getId() { return id; }
    public Department getDepartment() { return department; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public String getType() { return type; }
    public float getCost() { return cost; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setDepartment(Department department) { this.department = department; }
    public void setCategory(String category) { this.category = category; }
    public void setStatus(String status) { this.status = status; }
    public void setType(String type) { this.type = type; }
    public void setCost(float cost) { this.cost = cost; }
    public void setUser(User user) { this.user = user; }

}
