package com.mapp.budgetmanager.controllers;

import com.mapp.budgetmanager.dto.DepartmentDTO;
import com.mapp.budgetmanager.models.Department;
import com.mapp.budgetmanager.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping(value = "/create"
            , consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = "application/json"
    )
    public ResponseEntity<Department> addDepartment(@RequestBody DepartmentDTO dto){
        Department dept = service.addDepartment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dept);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> findAllDepartments() {
        List<Department> allDept = service.findAllDept();
        if (allDept.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allDept);
        return ResponseEntity.status(HttpStatus.FOUND).body(allDept);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findDeptById(@PathVariable Long id) {
        Department dept = service.findDeptById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(dept);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,@RequestBody DepartmentDTO dto) {
        Department update = service.updateDept(id, dto);
        if (update != null) return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment (@PathVariable Long id) {
        boolean deleted = service.deleteDept(id);
        if (deleted) return ResponseEntity.status(HttpStatus.FOUND).body("Department deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("Error encounted when trying to delete this department.");
    }



}
