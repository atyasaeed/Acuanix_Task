package com.acuanix.hr.entitiy;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;
    
    @OneToOne()
    @JoinColumn(name = "manager")
    private Employee deptMnager;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public Employee getDeptMnager()
    {
	return deptMnager;
    }

    public void setDeptMnager(Employee deptMnager)
    {
	this.deptMnager = deptMnager;
    }

}
