package com.acuanix.hr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acuanix.hr.entitiy.Employee;
import com.acuanix.hr.exception.NoDataFoundException;
import com.acuanix.hr.service.EmployeeService;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping(path = EmployeeController.REST_URL)
public class EmployeeController
{
    static final String REST_URL = "/api";
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emps")
    public Page<Employee> getAllEmployee(@SearchSpec Specification<Employee> specs, Pageable page)
    {
	return employeeService.getAllEmp(specs, page);
    }

    @GetMapping("/deptEmps/{id}")
    
    public List<Employee> getDeptEmps(@PathVariable("id") Integer deptId )
    {
	return employeeService.getDeptEmps(deptId);
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer empId)
    {

	return employeeService.getEmpById(empId);

    }

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmp(@RequestBody Employee emp)
    {

	employeeService.save(emp);
	return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @PutMapping("/updateEmp")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp)
    {
	employeeService.save(emp);
	return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/deleteemp/{id}")
    public void deletEmp(@PathVariable("id") Integer empId)
    {
	employeeService.deleteEmp(empId);

    }

}
