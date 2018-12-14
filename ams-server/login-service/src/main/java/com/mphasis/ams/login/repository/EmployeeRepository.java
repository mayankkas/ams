package com.mphasis.ams.login.repository;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mphasis.ams.login.dynamo.entity.Employee;

@EnableScan
public interface EmployeeRepository extends DynamoDBCrudRepository<Employee, Integer>
{
//	Employee findByEid(BigInteger eid);

//	@Query("Select * from customer where firstname=?0")
//	List<Employee> findByFirstName(String firstName);
//
//	@Query("Select * from customer where lastname=?0")
//	List<Employee> findByLastName(String lastName);
	
	List<Employee> findByProjectCode(int projectCode);
	Employee findByPassword(String password);
	Employee findByEid(int eid);
	

}
