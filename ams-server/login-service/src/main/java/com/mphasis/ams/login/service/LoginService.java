package com.mphasis.ams.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ams.login.cassandra.EmployeeRepository;
import com.mphasis.ams.login.cassandra.entity.Employee;

@Service
public class LoginService {


	@Autowired
	private EmployeeRepository empRepo;

	public Employee addEmployee(int eid, String emailId, String role, String password) {

		if (this.empRepo.findById(eid).orElse(null) == null) {
			Employee emp = new Employee(eid, emailId, role, password);
			return this.empRepo.save(emp);
		}
		return null;
	}
	
	public void deleteEmployee(int eid) {

		Employee emp = this.empRepo.findById(eid).orElse(null);
		System.out.println(emp);
		if(emp!=null)
			this.empRepo.delete(emp);
		System.out.println(this.empRepo.findById(eid).orElse(null));
	}
	
	public String listEmployee(){
		System.out.println("testEmployee");
		StringBuilder b = new StringBuilder();
		this.empRepo.findAll().forEach(employee -> {
			b.append(employee.toString()+"\n");
		});
		return b.toString();
	}

}
