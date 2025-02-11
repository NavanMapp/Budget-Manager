package com.mapp.budgetmanager.controllers;

import com.mapp.budgetmanager.dto.SiteDTO;
import com.mapp.budgetmanager.models.Site;
import com.mapp.budgetmanager.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/site")
public class SiteController {

    private final SiteService service;

    @Autowired
    public SiteController(SiteService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Site> addSite(@RequestBody SiteDTO dto) {
        Site site = service.addSite(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(site);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Site>> findAllSites() {
        List<Site> site = service.getAllSites();
        return ResponseEntity.ok().body(site);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Site> findSiteById(@PathVariable Long id) {
        Site site = service.findById(id);
        return ResponseEntity.ok().body(site);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable Long id, @RequestBody SiteDTO dto) {
        Site update = service.updateSite(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSite(@PathVariable Long id) {
        boolean deleted = service.deleteSite(id);
        if (deleted)
            return ResponseEntity.ok("Site has been successfully deleted. ");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Error encounted when trying to delete this site.");
    }
}
