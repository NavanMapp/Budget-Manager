package com.mapp.budgetmanager.dto;

import com.mapp.budgetmanager.models.Dashboard;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.models.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DepartmentDTO {

    private String name;
    private String status;
    private BigDecimal totalBudget;
    private BigDecimal spentAmount;
    private BigDecimal remainingAmount;
    private LocalDate date;
    private List<User> user;
    private Site site;
    private List<Dashboard> dashboard;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getTotalBudget() { return totalBudget; }
    public void setTotalBudget(BigDecimal totalBudget) { this.totalBudget = totalBudget; }

    public BigDecimal getSpentAmount() { return spentAmount; }
    public void setSpentAmount(BigDecimal spentAmount) { this.spentAmount = spentAmount; }

    public BigDecimal getRemainingAmount() { return remainingAmount; }
    public void setRemainingAmount(BigDecimal remainingAmount) { this.remainingAmount = remainingAmount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public List<User> getUser() { return user; }
    public void setUser(List<User> user) { this.user = user; }

    public Site getSite() { return site; }
    public void setSite(Site site) { this.site = site; }

    public List<Dashboard> getDashboard() { return dashboard; }
    public void setDashboard(List<Dashboard> dashboard) { this.dashboard = dashboard; }
}
