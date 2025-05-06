package com.mapp.budgetmanager.dto;

import com.mapp.budgetmanager.models.Dashboard;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.models.User;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class DepartmentDTO {

    private String name;
    private String status;
    private BigDecimal totalBudget;
    private BigDecimal spentAmount;
    private BigDecimal remainingAmount;
    private List<User> user;
    private Long siteId ;
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

    public List<User> getUser() { return user; }
    public void setUser(List<User> user) { this.user = user; }
//
    public Long getSiteId() { return siteId; }
    public void setSiteId(Long siteId) { this.siteId = siteId; }
//
    public List<Dashboard> getDashboard() { return dashboard; }
    public void setDashboard(List<Dashboard> dashboard) { this.dashboard = dashboard; }
}
