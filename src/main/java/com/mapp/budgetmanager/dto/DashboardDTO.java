package com.mapp.budgetmanager.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DashboardDTO {

    private Date date;
    private Long departmentId;
    private String description;
    private String category;
    private String status;
    private String type;
    private BigDecimal cost;
    private Long userId;

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

}
