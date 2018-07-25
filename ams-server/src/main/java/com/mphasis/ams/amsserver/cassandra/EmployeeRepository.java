package com.mphasis.ams.amsserver.cassandra;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.mphasis.ams.amsserver.cassandra.entity.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, BigInteger>//CrudRepository<Customer, String> 
{
//	Employee findByEid(BigInteger eid);

//	@Query("Select * from customer where firstname=?0")
	List<Employee> findByFirstName(String firstName);

//	@Query("Select * from customer where lastname=?0")
	List<Employee> findByLastName(String lastName);

}
