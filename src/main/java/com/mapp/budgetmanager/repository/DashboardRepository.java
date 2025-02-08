package com.mapp.budgetmanager.repository;

import com.mapp.budgetmanager.models.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    Optional<Dashboard> findById(Long id);
}
