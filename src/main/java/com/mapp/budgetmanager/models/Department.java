package com.mapp.budgetmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private BigDecimal totalBudget;
    private BigDecimal spentAmount;
    private BigDecimal remainingAmount;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "site_id")
    @JsonBackReference
    private Site site;

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<User> user;

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Dashboard> dashboards;

    public Department(Long id, String name, String status, BigDecimal totalBudget,
                      BigDecimal spentAmount, BigDecimal remainingAmount,
                      LocalDate date,
                      Site site, List<User> user, List<Dashboard> dashboards
    ) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.totalBudget = totalBudget;
        this.spentAmount = spentAmount;
        this.remainingAmount = remainingAmount;
        this.date = date;
        this.site = site;
//        this.user = user;
//        this.dashboards = dashboards;
    }

    public Department() {}

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Site getSite() { return site; }
    public String getStatus() { return status; }
    public BigDecimal getTotalBudget() { return totalBudget; }
    public BigDecimal getSpentAmount() { return spentAmount; }
    public BigDecimal getRemainingAmount() { return remainingAmount; }
    public LocalDate getDate() { return date; }
//    public List<User> getUser() { return user; }
//    public List<Dashboard> getDashboards() { return dashboards; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSite(Site site) { this.site = site; }
    public void setStatus(String status) { this.status = status; }
    public void setTotalBudget(BigDecimal totalBudget) { this.totalBudget = totalBudget; }
    public void setSpentAmount(BigDecimal spentAmount) { this.spentAmount = spentAmount; }
    public void setRemainingAmount(BigDecimal remainingAmount) { this.remainingAmount = remainingAmount; }
    public void setDate (LocalDate date) { this.date = date; }
//    public void setUser(List<User> user) { this.user = user; }
//    public void setDashboards(List<Dashboard> dashboards) { this.dashboards = dashboards; }
}
