package com.mphasis.ams.login.repository;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mphasis.ams.login.dynamo.entity.Employee;

/**
 * @author Hamza.Khan
 *
 */
@EnableScan
public interface EmployeeRepository extends DynamoDBCrudRepository<Employee, Integer> {

	List<Employee> findByProjectCode(int projectCode);

	Employee findByPassword(String password);

	Employee findByEid(int eid);

}
