package com.acuanix.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.acuanix.hr.entitiy.Employee;
import com.acuanix.hr.entitiy.Users;
import com.acuanix.hr.repositry.UserRepo;
import com.sun.xml.bind.v2.runtime.output.Encoded;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

	Users user = userRepo.findByUsernameIgnoreCase(username);
	if (user == null)
	{
	    throw new UsernameNotFoundException("Invaild username Or Password");
	} else
	    return new User(user.getEmail(), user.getPassword(), user.getRoles());
    }

    public void saveUser(Users user)
    {
	user.setPassword(encoder.encode(user.getPassword()));
	user.setUsername(user.getEmail());
	userRepo.save(user);
    }

    public Page<Users> getAllUsers(Specification<Users> specs, Pageable page)
    {
	return userRepo.findAll(specs, page);
    }

    public Users getUser(Integer id)
    {
	return userRepo.findById(id).orElseThrow();
    }

    public Users updateUser(Users user)
    {

	return userRepo.save(user);
    }

    public void deleteUser(Integer Id)
    {
	userRepo.deleteById(Id);
    }

    public List<Users> getAllUsers()
    {

	return (List<Users>) userRepo.findAll();
    }
}
