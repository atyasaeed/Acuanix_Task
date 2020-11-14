package com.acuanix.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acuanix.hr.entitiy.Department;
import com.acuanix.hr.entitiy.Department;
import com.acuanix.hr.repositry.DepartmentRepo;
import com.acuanix.hr.repositry.EmployeeRepo;

@Service
@Transactional
public class DepartementService
{

    @Autowired
    private DepartmentRepo departmentRepo;

    public Page<Department> getAllDept(Specification<Department> specs, Pageable page)
    {
	return departmentRepo.findAll(specs, page);
    }

    public Department getDeptById(Integer deptId)
    {

	return departmentRepo.findById(deptId).orElse(null);
    }

    public Department save(Department dept)
    {
	return departmentRepo.save(dept);
    }

    public Department updateDept(Department dept)
    {

	return departmentRepo.save(dept);
    }

    public void deleteDept(Integer deptId)
    {
	departmentRepo.deleteById(deptId);
    }

}
