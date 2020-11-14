package com.acuanix.hr.util;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.acuanix.hr.entitiy.Users;
import com.acuanix.hr.security.Role;
import com.acuanix.hr.service.UserService;

@Component
public class FirstTimeInitalizer implements CommandLineRunner
{
    private final Log logger = LogFactory.getLog(FirstTimeInitalizer.class);
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception
    {
	if (userService.getAllUsers().isEmpty())
	{
	    logger.info(" No Users account found, Creating some users");

	    Users user = new Users();
	    user.setEmail("ateya.said@gmail.com");
	    user.setPassword("New123456");
	    user.addRole(Role.ADMIN);
	    userService.saveUser(user);

	}

    }
}
