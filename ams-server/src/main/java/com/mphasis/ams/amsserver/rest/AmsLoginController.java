package com.mphasis.ams.amsserver.rest;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ams.amsserver.rest.request.AmsUser;
import com.mphasis.ams.amsserver.service.AmsLoginService;

@RestController
public class AmsLoginController {
	
	@Autowired
	AmsLoginService loginService;
	
	@GetMapping("/add")
	public String add(){
		
		BigInteger eid = BigInteger.valueOf(2346557);
		String firstName = "Mayank";
		String lastName = "Kastwar";
		String emailId = "mayank@mphasis.com";
		String password = "mayank";
		
		return "Added User: "+loginService.addEmployee(eid, firstName, lastName, emailId, password);
	}
	
	@GetMapping("/delete")
	public String delete(){
		BigInteger eid = BigInteger.valueOf(2346557);
		loginService.deleteEmployee(eid);
		return "Deleted User";
	}
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody AmsUser user){
		return "Added User: "+loginService.addEmployee(user.getEid(), user.getFirstName(), user.getLastName(), user.getEmailId(), user.getPassword());
	}
	
	@DeleteMapping("/deleteuser")
	public String deleteuser(BigInteger eid){
		loginService.deleteEmployee(eid);
		return "Deleted User";
	}
}
