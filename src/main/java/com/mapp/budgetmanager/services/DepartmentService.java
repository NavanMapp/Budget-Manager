package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.repository.DepartmentRespository;

import java.util.List;
import java.util.Optional;

public class DepartmentService {
    /**
     * This Service is to get all departmental budget amounts of a particular site.
     * Or for Head Office admins/co-ordinators, an overview of different sites.
     * calculate their: 1. spent amount,
     *                  2. remaining amount
     *                  3. potential expenditures*/

    private final DepartmentRespository deptRepo;

    public DepartmentService(DepartmentRespository deptRepo) {
        this.deptRepo = deptRepo;
    }

    // CREATE/ADD a department
    public Department addDepartment(Department dept) {
        return deptRepo.save(dept);
    }

    // READ: View Full budgets per Site for all department
    public List<Department> findAllSites(Department site) {
        return deptRepo.findAll();
    }

    // pass in 1 siteId, all departments.
    public Optional<Department> findById(Long id) {
        return deptRepo.findById(id);
    }

    // UPDATE department & site
    public Department updateDept(Long id) {
        return deptRepo.findById(id).map(
                deptExists -> {
                    deptExists.setName(deptExists.getName());
                    deptExists.setTotalBudget(deptExists.getTotalBudget());
                    return deptRepo.save(deptExists);
                }
        ).orElseThrow(() -> new RuntimeException("Update cannot be done"));
    }
    // DELETE department & site
    public void deleteDept(Long id) {
        if (deptRepo.existsById(id)) {
            deptRepo.deleteById(id);
        } else {
            throw new RuntimeException("Department cannot be deleted: Id not found");
        }
    }


    // READ: View Full budget per Site for individual department
    // pass in 1 siteId & 1 departmentId.

}
