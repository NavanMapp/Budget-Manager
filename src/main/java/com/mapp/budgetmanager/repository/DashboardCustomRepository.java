package com.mapp.budgetmanager.repository;

import com.mapp.budgetmanager.models.Dashboard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardCustomRepository {
    List<Dashboard> findByFilters(Long deptId, Long userId, String category, String status,
                                  String type);
}
