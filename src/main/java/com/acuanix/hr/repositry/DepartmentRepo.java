package com.acuanix.hr.repositry;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.acuanix.hr.entitiy.Department;

import java.util.Optional;

@Repository
public interface DepartmentRepo
	extends PagingAndSortingRepository<Department, Integer>, JpaSpecificationExecutor<Department>
{
	
}
