package com.acuanix.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acuanix.hr.entitiy.Employee;
import com.acuanix.hr.repositry.EmployeeRepo;

@Service
@Transactional
public class EmployeeService
{
    @Autowired
    private EmployeeRepo employeeRepo;

    public Page<Employee> getAllEmp(Specification<Employee> specs, Pageable page)
    {
	return employeeRepo.findAll(specs, page);
    }

    public Employee getEmpById(Integer empId)
    {

	return employeeRepo.findById(empId).orElseThrow();
    }

    public List<Employee> getDeptEmps(Integer deptId)
    {
	return employeeRepo.findAllByDepartmentId(deptId);

    }

    public Employee save(Employee emp)
    {
	return employeeRepo.save(emp);
    }

    public Employee updateEmp(Employee emp)
    {

	return employeeRepo.save(emp);
    }

    public void deleteEmp(Integer empId)
    {
	employeeRepo.deleteById(empId);
    }

}
