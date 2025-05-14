package com.mapp.budgetmanager.controllers;

import com.mapp.budgetmanager.dto.DashboardDTO;
import com.mapp.budgetmanager.models.Dashboard;
import com.mapp.budgetmanager.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private DashboardService dashService;

    @Autowired
    public DashboardController(DashboardService dashService) {
        this.dashService = dashService;
    }

    // Create a new record entry on the dashboard
    @PostMapping(value = "/create"
            , consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json" )
    public ResponseEntity<Dashboard> addDashboardEntry(@RequestBody DashboardDTO dto) {
        Dashboard dash = dashService.addDashEntry(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dash);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dashboard>> getAllDashboardEntries(){
        List<Dashboard> dash = dashService.findAllEntries();
        return ResponseEntity.ok(dash);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dashboard> getEntryById(@PathVariable Long id){
        Dashboard entry = dashService.findEntryById(id);
        if (entry != null) return ResponseEntity.ok(entry);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable Long id, @RequestBody DashboardDTO dto) {
        Dashboard entry = dashService.updateDashboardEntry(id, dto);
        if (entry != null) return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Entry updated successfully");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Error encoutered when updating entry");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        boolean deleted = dashService.deleteEntry(id);
        if (deleted) return ResponseEntity.status(HttpStatus.FOUND)
                .body("Entry deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Error encounted trying to delete entry");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Dashboard>> getFilteredEntry(@RequestParam(required = false) Long deptId,
                                                            @RequestParam(required = false) Long userId,
                                                            @RequestParam(required = false) String category,
                                                            @RequestParam(required = false) String status,
                                                            @RequestParam(required = false) String type) {
        List<Dashboard> entry = dashService.getFilteredEntry(deptId, userId, category, status, type);
        return ResponseEntity.ok(entry);
    }
}
