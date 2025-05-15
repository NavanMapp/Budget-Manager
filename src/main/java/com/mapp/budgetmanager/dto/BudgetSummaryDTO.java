package com.mapp.budgetmanager.dto;

import java.math.BigDecimal;

public class BudgetSummaryDTO {

    BigDecimal spentAmount;
    BigDecimal remainingAmount;

    public BudgetSummaryDTO(BigDecimal spentAmount, BigDecimal remainingAmount) {
        this.spentAmount = spentAmount;
        this.remainingAmount = remainingAmount;
    }

    public void setSpentAmount(BigDecimal spentAmount) { this.spentAmount = spentAmount; }
    public void setRemainingAmount(BigDecimal remainingAmount) { this.remainingAmount = remainingAmount; }
}
