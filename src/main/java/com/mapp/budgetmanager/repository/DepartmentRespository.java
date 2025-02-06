package com.mapp.budgetmanager.repository;

import com.mapp.budgetmanager.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {
    @Override
    Optional<Department> findById(Long aLong);
    Department createDept (Department department);
    List<Department> getAllDept();
    List<Department> getTotalBudget(BigDecimal totalBudget);
    List<Department> getStatus (String status);
    List<Department> calculateRemaining (BigDecimal remainingAmount);
    List<Department> calculateSpent(BigDecimal spentAmount);
    Department updateDept(Department department);
    Optional<Department> delete(Long id);
}
