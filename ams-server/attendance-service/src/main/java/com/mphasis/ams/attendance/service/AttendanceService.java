package com.mphasis.ams.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.mphasis.ams.attendance.cassandra.CustomerRepository;
import com.mphasis.ams.attendance.cassandra.EmployeeRepository;
import com.mphasis.ams.attendance.cassandra.entity.Customer;
import com.mphasis.ams.attendance.cassandra.entity.Employee;

@Service
public class AttendanceService {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private EmployeeRepository empRepo;

	public Employee addEmployee(int eid, String firstName, String lastName, String emailId, String password) {

		if (this.empRepo.findById(eid).orElse(null) == null) {
			Employee emp = new Employee(eid, firstName, lastName, emailId, password);
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
	
	public String testEmployee(){
		System.out.println("testEmployee");
		StringBuilder b = new StringBuilder();
		this.empRepo.findAll().forEach(employee -> {
			b.append(employee.toString()+"\n");
		});
		return b.toString();
	}

	public void testDataRepo() {
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Customer(UUIDs.timeBased(), "Alice", "Smith"));
		this.repository.save(new Customer(UUIDs.timeBased(), "Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

}
