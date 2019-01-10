package com.mphasis.ams.login.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mphasis.ams.login.rest.formbean.VerificationFormBean;

@EnableScan
public interface VerificationCodeRepository extends CrudRepository<VerificationFormBean, Integer> {

	
}
