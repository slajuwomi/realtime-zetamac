package com.slajuwomi.realtime_zetamac.service;

import com.slajuwomi.realtime_zetamac.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Optional<Department> fetchDepartmentById(Long departmentId);

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
