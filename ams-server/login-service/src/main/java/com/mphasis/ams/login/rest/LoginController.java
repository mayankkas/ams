package com.mphasis.ams.login.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ams.login.rest.request.LoginUser;
import com.mphasis.ams.login.service.impl.LoginServiceImpl;



@RestController
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@GetMapping("/")
	public String get() {
		return loginServiceImpl.listEmployee();
	}

	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") int id) {

		String role = "admin";
		String emailId = "name@mphasis.com";
		String password = "password";

		return "Added User: " + loginServiceImpl.addEmployee(id, emailId, role, password);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		loginServiceImpl.deleteEmployee(id);
		return "Deleted User";
	}

	@PostMapping("/adduser")
	public String addUser(@RequestBody LoginUser user) {
		return "Added User: "
				+ loginServiceImpl.addEmployee(user.getEid(), user.getEmailId(), user.getRole(), user.getPassword());
	}

	@DeleteMapping("/deleteuser")
	public String deleteuser(int eid) {
		loginServiceImpl.deleteEmployee(eid);
		return "Deleted User";
	}
}
