package com.mapp.budgetmanager.repository;

import com.mapp.budgetmanager.models.Dashboard;
import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DashboardCustomRepoImpl implements DashboardCustomRepository  {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Dashboard> findByFilters(Long deptId, Long userId, String category, String status, String type) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dashboard> cq = cb.createQuery(Dashboard.class);
        Root<Dashboard> root = cq.from(Dashboard.class);

        List< Predicate> predicates = new ArrayList<>();

        if (deptId != null) predicates.add(cb.equal(root.get("departmentId"), deptId));
        if (userId != null) predicates.add((cb.equal(root.get("userId"), userId)));
        if (category != null) predicates.add((cb.equal(root.get("category"), category)));
        if (status != null) predicates.add((cb.equal(root.get("status"), status)));
        if (type != null) predicates.add((cb.equal(root.get("type"), type)));

        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
