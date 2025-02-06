package com.mapp.budgetmanager.repository;

import com.mapp.budgetmanager.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

    @Override
    Optional<Site> findById(Long aLong);
    Site createSite (Site site);
    List<Site> getAll();
    Site update(Site site);
    Optional<Site> delete(Long id);
}
