package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.controllers.DepartmentController;
import com.mapp.budgetmanager.dto.DepartmentDTO;
import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.repository.DepartmentRespository;
import com.mapp.budgetmanager.repository.SiteRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    /**
     * This Service is to get all departmental budget amounts of a particular site.
     * Or for Head Office admins/co-ordinators, an overview of different sites.
     * calculate their: 1. spent amount,
     *                  2. remaining amount
     *                  3. potential expenditures*/

    private final DepartmentRespository deptRepo;
    private final SiteRepository siteRepo;

    @Autowired
    public DepartmentService(DepartmentRespository deptRepo, SiteRepository siteRepo) {
        this.deptRepo = deptRepo;
        this.siteRepo = siteRepo;
    }

    // CREATE/ADD a department
    public Department addDepartment(DepartmentDTO dto) {
        Department dept = new Department();
        if (dept == null) throw new IllegalArgumentException("Department cannot be created");
        dept.setName(dto.getName());
        dept.setTotalBudget(dto.getTotalBudget());
        dept.setDate(dto.getDate());
        dept.setSpentAmount(dto.getSpentAmount());
        dept.setRemainingAmount(dto.getRemainingAmount());
        dept.setStatus(dto.getStatus());
        dept.setUser(dto.getUser());
//        dept.setDashboards(dto.getDashboard());
        Site site = siteRepo.findById(dto.getSiteId())
                .orElseThrow(() -> new EntityNotFoundException("Site Not Found"));
        dept.setSite(site);
        return deptRepo.save(dept);
    }

    // READ: View Full budgets per Site for all department
    public List<Department> findAllDept() {
        return deptRepo.findAll();
    }

    // pass in 1 siteId, all departments.
    public Department findDeptById(Long id) {
        return deptRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department does not exist"));
    }

    // UPDATE department & site
    public Department updateDept(Long id, DepartmentDTO dto) {
        return deptRepo.findById(id).map(
                deptExists -> {
                    deptExists.setName(dto.getName());
                    deptExists.setStatus(dto.getStatus());
                    deptExists.setTotalBudget(dto.getTotalBudget());
                    deptExists.setSpentAmount(dto.getSpentAmount());
                    deptExists.setRemainingAmount(dto.getRemainingAmount());
                    return deptRepo.save(deptExists);
                }
        ).orElseThrow(() -> new IllegalArgumentException("Update cannot be done"));
    }
    // DELETE department & site
    public boolean deleteDept(Long id) {
        if (deptRepo.existsById(id)) {
            deptRepo.deleteById(id);
            return true;
        }
        return false;
    }


    // READ: View Full budget per Site for individual department
    // pass in 1 siteId & 1 departmentId.

}
