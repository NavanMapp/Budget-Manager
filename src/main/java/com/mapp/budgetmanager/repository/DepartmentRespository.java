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
    /**
     * TotalBudget(Entered by finance account holder)
     * Calculate RemainingAmount = TotalBudget - Cost of Item from Dashboard
     *
     * */
}
