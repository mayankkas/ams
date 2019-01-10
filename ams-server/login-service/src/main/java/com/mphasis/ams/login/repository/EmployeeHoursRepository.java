package com.mphasis.ams.login.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;
/**
 * @author Hamza.Khan
 *
 */
@EnableScan
public interface EmployeeHoursRepository extends DynamoDBCrudRepository<EmployeeHoursBean, Integer> {
	
	List<EmployeeHoursBean> findByMonth(String month);
	
	
	
	
	
}
