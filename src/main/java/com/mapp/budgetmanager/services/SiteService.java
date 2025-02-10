package com.mapp.budgetmanager.services;

import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    private final SiteRepository siteRepo;

    public SiteService(SiteRepository siteRepo) {
        this.siteRepo = siteRepo;
    }

    // Create/Add site
    public Site addSite(Site site) {
        return siteRepo.save(site);
    }

    // Read/Get All sites
    public List<Site> getAllSites() {
        return siteRepo.findAll();
    }

    // Read/Get site by their id
    public Site findById(Long id) {
        return siteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Site cannot be found"));
    }

    // Update a sites details
    public Site updateSite(Long id) {
        return siteRepo.findById(id).map(
                siteExists -> {
                    siteExists.setName(siteExists.getName());
                    return siteRepo.save(siteExists);
                }
        ).orElseThrow(() -> new RuntimeException("Site not found"));
    }

    // Delete a particular site
    public void deleteSite(Long id) {
        if (siteRepo.existsById(id)) {
            siteRepo.deleteById(id);
        } else {
            throw new RuntimeException("Site Id cannot be found: ");
        }
    }

}
