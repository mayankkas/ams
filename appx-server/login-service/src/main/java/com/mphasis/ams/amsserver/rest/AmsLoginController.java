package com.mphasis.ams.amsserver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ams.amsserver.rest.request.AmsUser;
import com.mphasis.ams.amsserver.service.AmsLoginService;

@RestController
public class AmsLoginController {
	
	@Autowired
	AmsLoginService loginService;
	
	@GetMapping("/")
	public String get(){
		return loginService.testEmployee();
	}
	
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") int id){
		
		String firstName = "firstname";
		String lastName = "lastname";
		String emailId = "name@mphasis.com";
		String password = "password";
		
		return "Added User: "+loginService.addEmployee(id, firstName, lastName, emailId, password);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
//		BigInteger eid = BigInteger.valueOf(2346557);
		loginService.deleteEmployee(id);
		return "Deleted User";
	}
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody AmsUser user){
		return "Added User: "+loginService.addEmployee(user.getEid(), user.getFirstName(), user.getLastName(), user.getEmailId(), user.getPassword());
	}
	
	@DeleteMapping("/deleteuser")
	public String deleteuser(int eid){
		loginService.deleteEmployee(eid);
		return "Deleted User";
	}
}
