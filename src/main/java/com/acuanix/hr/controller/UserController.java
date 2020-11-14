package com.acuanix.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acuanix.hr.entitiy.Users;
import com.acuanix.hr.security.Role;
import com.acuanix.hr.service.UserService;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping(path = UserController.REST_URL)
@PreAuthorize("hasRole('ADMIN')")
public class UserController
{

    static final String REST_URL = "/api";

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<Users> addUser(@RequestBody Users user)
    {
	user.setUsername(user.getEmail());
	user.addRole(Role.USER);

	userService.saveUser(user);
	return new ResponseEntity<Users>(user, HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public Page<Users> getAllUser(@SearchSpec Specification<Users> specs, Pageable page)
    {
	return userService.getAllUsers(specs, page);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<Users> updateEmp(@RequestBody Users user)
    {
	userService.updateUser(user);
	return new ResponseEntity<Users>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public void deletUser(@PathVariable("id") Integer id)
    {
	userService.deleteUser(id);

    }

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") Integer id)
    {

	return userService.getUser(id);

    }
}
