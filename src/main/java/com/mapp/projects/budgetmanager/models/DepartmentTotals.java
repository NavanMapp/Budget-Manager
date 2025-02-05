package com.mapp.projects.budgetmanager.models;

//@Entity
//@Table(name = "Departments")
public class DepartmentTotals {

    private Long id;
    private String branch;
    private String status;
    private float totalBudget;
    private float spentAmount;
    private float remainingAmount;

    public DepartmentTotals(Long id, String branch, String status,
                            float totalBudget, float spentAmount, float remainingAmount) {
        this.id = id;
        this.branch = branch;
        this.status = status;
        this.totalBudget = totalBudget;
        this.spentAmount = spentAmount;
        this.remainingAmount = remainingAmount;
    }

    // Getters
    public Long getId() { return id; }
    public String branch() { return branch; }
    public String status() { return status; }
    public float totalBudget() { return totalBudget; }
    public float spentAmount() { return spentAmount; }
    public float remainingAmount() { return remainingAmount; }

    // Setters
    public void setId(Long id ) { this.id = id; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setStatus(String status) { this.status = status; }
    public void setTotalBudget(float totalBudget) { this.totalBudget = totalBudget; }
    public void setSpentAmount(float spentAmount) { this.spentAmount = spentAmount; }
    public void setRemainingAmount(float remainingAmount) { this.remainingAmount = remainingAmount; }

}
