package com.mphasis.ams.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ams.attendance.cassandra.WorkHoursFormBeanRepository;
import com.mphasis.ams.attendance.cassandra.entity.WorkHoursFormBean;

@Service
public class WorkHoursFormBeanService {

	@Autowired
	WorkHoursFormBeanRepository updateProfileRepository;
	
	public Boolean addHours(WorkHoursFormBean updateProfile) {
		updateProfileRepository.save(updateProfile);
		return true;
	}

}
