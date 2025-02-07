package com.mapp.budgetmanager.repository;

import com.mapp.budgetmanager.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {

    Optional<Department> findById(Long id);
    List<Department> findByTotalBudget(BigDecimal totalBudget);
    List<Department> findByStatus(String status);
    List<Department> findByRemainingAmount(BigDecimal remainingAmount);
    List<Department> findBySpentAmount(BigDecimal spentAmount);
}
