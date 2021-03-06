package com.mphasis.ams.login.rest.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.exception.BusinessException;

import com.mphasis.ams.login.rest.controller.LoginController;
import com.mphasis.ams.login.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Hamza.Khan
 *
 */
@Controller
public class LoginControllerImpl implements LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	//request will first go through intercepter after request is authenticated then it will run through Api
	Logger log = LoggerFactory.getLogger(this.getClass());
	

	//login api if user exist then it open session and keep current user in session until the user logout
	@Override
	@PostMapping("/login/{employeeId}/{password}")
	public ResponseEntity<Employee> login(@PathVariable int employeeId, @PathVariable String password,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Employee employee = loginServiceImpl.login(employeeId, password, request, response);
		if (employee != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("employeeId", employeeId);

			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	@DeleteMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "Successfully logout";
	}

}
