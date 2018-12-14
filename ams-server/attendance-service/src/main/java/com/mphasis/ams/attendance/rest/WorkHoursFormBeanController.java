package com.mphasis.ams.attendance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.ams.attendance.cassandra.entity.WorkHoursFormBean;
import com.mphasis.ams.attendance.service.WorkHoursFormBeanService;

@RestController
public class WorkHoursFormBeanController {

	@Autowired
	WorkHoursFormBeanService updateProfileService;

	@PostMapping("/addhours")
	public ResponseEntity<WorkHoursFormBean> addHours(@RequestBody WorkHoursFormBean workHours) {
		return new ResponseEntity<WorkHoursFormBean>(workHours, HttpStatus.OK);
	}
	@PutMapping("/updateHours/{empid}")
	public ResponseEntity<WorkHoursFormBean> updateHours(@RequestBody WorkHoursFormBean workHours,@PathVariable int empId)
	{
		
		return new ResponseEntity<WorkHoursFormBean>(workHours,HttpStatus.OK);
	}
	
	

	

}
