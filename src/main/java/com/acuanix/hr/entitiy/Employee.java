package com.acuanix.hr.entitiy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;
    @Size(min = 10, max = 100)
    @Column(nullable = false)
    @NotBlank
    private String empName;

    @Column(nullable = false)
    private double empSalary;

    @JsonFormat(pattern = "dd/MM/YYYY")
    private Date hireDate;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email(message = "Invaild Email")
    private String empEmail;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 11, max = 20)
    private String empPhone;

    @Column(nullable = false)
    @NotBlank
    private String empAddress;

    @ManyToOne()
    private Department department;

    public Integer getEmpId()
    {
	return empId;
    }

    public void setEmpId(Integer empId)
    {
	this.empId = empId;
    }

    public String getEmpName()
    {
	return empName;
    }

    public void setEmpName(String empName)
    {
	this.empName = empName;
    }

    public double getEmpSalary()
    {
	return empSalary;
    }

    public void setEmpSalary(double empSalary)
    {
	this.empSalary = empSalary;
    }

    public String getEmpEmail()
    {
	return empEmail;
    }

    public void setEmpEmail(String empEmail)
    {
	this.empEmail = empEmail;
    }

    public String getEmpPhone()
    {
	return empPhone;
    }

    public void setEmpPhone(String empPhone)
    {
	this.empPhone = empPhone;
    }

    public String getEmpAddress()
    {
	return empAddress;
    }

    public void setEmpAddress(String empAddress)
    {
	this.empAddress = empAddress;
    }

    public Date getHireDate()
    {
	return hireDate;
    }

    public void setHireDate(Date hireDate)
    {
	this.hireDate = hireDate;
    }

    public Department getDepartment()
    {
	return department;
    }

    public void setDepartment(Department department)
    {
	this.department = department;
    }

}
