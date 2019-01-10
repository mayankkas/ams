package com.mphasis.ams.login.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.ams.login.dynamo.entity.Employee;
/**
 * @author Hamza.Khan
 *
 */
public interface LoginService {

	public Employee login(int employeeId,String password,HttpServletRequest request,HttpServletResponse response);
	public void logout();
}
