package com.acuanix.hr.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.acuanix.hr.entitiy.Employee;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer>, JpaSpecificationExecutor<Employee>
{

    List<Employee> findAllByDepartmentId(Integer deptId);

}
