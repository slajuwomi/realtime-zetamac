package com.slajuwomi.realtime_zetamac.controller;

import com.slajuwomi.realtime_zetamac.entity.Department;
import com.slajuwomi.realtime_zetamac.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")

    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")

    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")

    public Optional<Department> fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @PutMapping("/departments/{id}")

    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("/departments/{id}")

    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
