package com.acuanix.hr.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.acuanix.hr.entitiy.Department;
import com.acuanix.hr.entitiy.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users>
{

    Users findByUsernameIgnoreCase(String userName);

}
