package com.acuanix.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acuanix.hr.entitiy.Department;
import com.acuanix.hr.service.DepartementService;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping(path = DepartmentController.REST_URL)
public class DepartmentController
{

    static final String REST_URL = "/api";
    @Autowired
    DepartementService departementService;

    @GetMapping("/depts")
    public Page<Department> getAllDepartment(@SearchSpec Specification<Department> specs, Pageable page)
    {
	return departementService.getAllDept(specs, page);
    }

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer empId)
    {

	return departementService.getDeptById(empId);

    }

    @PostMapping("/adddDept")
    public ResponseEntity<Department> addDept(@RequestBody Department dept)
    {
	departementService.save(dept);
	return new ResponseEntity<Department>(dept, HttpStatus.OK);
    }

    @PutMapping("/updateDept")
    public void updateDept(@RequestBody Department dept)
    {
	departementService.updateDept(dept);

    }

    @DeleteMapping("/deleteDept/{id}")
    public void deletDept(@PathVariable("id") Integer deptId)
    {
	departementService.deleteDept(deptId);

    }
}
