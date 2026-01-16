package com.slajuwomi.realtime_zetamac.repository;

import com.slajuwomi.realtime_zetamac.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
