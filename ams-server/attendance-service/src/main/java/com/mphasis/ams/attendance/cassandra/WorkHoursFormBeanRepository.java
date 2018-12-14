package com.mphasis.ams.attendance.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.mphasis.ams.attendance.cassandra.entity.WorkHoursFormBean;

public interface WorkHoursFormBeanRepository extends CassandraRepository<WorkHoursFormBean, Integer> {
	

}
