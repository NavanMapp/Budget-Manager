package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.dto.DepartmentDTO;
import com.mapp.budgetmanager.models.Dashboard;
import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.repository.DashboardRepository;
import com.mapp.budgetmanager.repository.DepartmentRespository;
import com.mapp.budgetmanager.repository.SiteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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
    private final DashboardRepository dashRepo;

    @Autowired
    public DepartmentService(DepartmentRespository deptRepo, SiteRepository siteRepo, DashboardRepository dashRepo) {
        this.deptRepo = deptRepo;
        this.siteRepo = siteRepo;
        this.dashRepo = dashRepo;
    }

    public DepartmentDTO convertToDTO(Department dept) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setSiteId(dept.getId());
        dto.setName(dept.getName());
        dto.setTotalBudget(dept.getTotalBudget());
        dto.setRemainingAmount(dto.getRemainingAmount());
        dto.setSpentAmount(dept.getSpentAmount());
        dto.setStatus(dept.getStatus());
        return dto;
    }

    // CREATE/ADD a department
    public Department addDepartment(DepartmentDTO dto) {
        Department dept = new Department();
        if (dept == null) throw new IllegalArgumentException("Department cannot be created");
        dept.setName(dto.getName());
        dept.setTotalBudget(dto.getTotalBudget());
        dept.setDate(new Date());
        dept.setStatus(dto.getStatus());
        Site site = siteRepo.findById(dto.getSiteId())
                .orElseThrow(() -> new EntityNotFoundException("Site Not Found"));
        dept.setSite(site);
        return deptRepo.save(dept);
    }
    // READ: View Full budgets per Site for all department
    public List<Department> findAllDept() { return deptRepo.findAll(); }
    // pass in 1 siteId, all departments.
    public Department findDeptById(Long id) {
        return deptRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department does not exist"));
    }
    // UPDATE department & site
    public Department updateDept(Long id, DepartmentDTO dto) {
        List<Dashboard> approvedEntries = dashRepo.findByDepartment_IdAndStatus(id, "Approved");
        BigDecimal spent = approvedEntries
                .stream()
                .map(Dashboard::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return deptRepo.findById(id).map(
                deptExists -> {
                    deptExists.setName(dto.getName());
                    deptExists.setStatus(dto.getStatus());
                    deptExists.setTotalBudget(dto.getTotalBudget());
                    Site site = siteRepo.findById(dto.getSiteId())
                            .orElseThrow(() -> new EntityNotFoundException("Site Not Found"));
                    deptExists.setSite(site);
                    BigDecimal total = deptExists.getTotalBudget();
                    BigDecimal remaining = total.subtract(spent);
                    deptExists.setSpentAmount(spent);
                    deptExists.setRemainingAmount(remaining);
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
