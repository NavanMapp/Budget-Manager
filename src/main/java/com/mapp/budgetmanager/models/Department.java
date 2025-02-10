package com.mapp.budgetmanager.models;

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

    @ManyToOne
    @JoinColumn(name = "siteId")
    private Site site;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> user;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Site getSite() { return site; }
    public String getStatus() { return status; }
    public BigDecimal getTotalBudget() { return totalBudget; }
    public BigDecimal getSpentAmount() { return spentAmount; }
    public BigDecimal getRemainingAmount() { return remainingAmount; }
    public LocalDate getDate() { return date; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSite(Site site) { site = site; }
    public void setStatus(String status) { this.status = status; }
    public void setTotalBudget(BigDecimal totalBudget) { this.totalBudget = totalBudget; }
    public void setSpentAmount(BigDecimal spentAmount) { this.spentAmount = spentAmount; }
    public void setRemainingAmount(BigDecimal remainingAmount) { this.remainingAmount = remainingAmount; }
    public void setDate (LocalDate date) { this.date = date; }

}
