package com.mphasis.ams.login.cassandra;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.mphasis.ams.login.cassandra.entity.Customer;

public interface CustomerRepository extends CassandraRepository<Customer, String>//CrudRepository<Customer, String> 
{

//	@Query("Select * from customer where firstname=?0")
	Customer findByFirstName(String firstName);

//	@Query("Select * from customer where lastname=?0")
	List<Customer> findByLastName(String lastName);

}
