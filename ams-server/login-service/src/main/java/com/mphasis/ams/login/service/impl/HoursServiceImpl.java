package com.mphasis.ams.login.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.mturk.model.ServiceException;
import com.mphasis.ams.login.repository.EmployeeHoursRepository;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;
import com.mphasis.ams.login.service.HoursService;

@Service
public class HoursServiceImpl implements HoursService {

	@Autowired
	EmployeeHoursRepository hourRepository;

	@Override
	public int calculateTotalHours(double overtime, double leaves, int forloughdays) {
		int hoursPerDay = 8, monthTotalDays, totalhours;
		String currentMonth;
		Calendar cal = Calendar.getInstance();
		currentMonth = new SimpleDateFormat("MMMMM").format(cal.getTime());
		monthTotalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// public holidays code here
		totalhours = (monthTotalDays - 8) * hoursPerDay;// Everymonth 8 days of weekends is fixed for every month
		totalhours = (int) ((totalhours + overtime) - (leaves * hoursPerDay));// overtime added and leaves total hours
																				// are deducted
		totalhours = totalhours - (forloughdays * hoursPerDay);// total hours of forlough days are deducted
		return totalhours;

	}

	@Override
	public Boolean addHours(EmployeeHoursBean emphourBean, HttpServletRequest request, HttpServletResponse response) {
		emphourBean.setTotalBilledHours(calculateTotalHours(emphourBean.getOverTimeHours(), emphourBean.getLeaves(),
				emphourBean.getFurloughDays()));
		// int count=(int) homeFormBeanRepository.count();
		// homeFormBean.setId(count++);
		Calendar cal = Calendar.getInstance();
		String currentMonth = new SimpleDateFormat("MMMMM").format(cal.getTime());
		emphourBean.setMonth(currentMonth);
		HttpSession session = request.getSession(false);
		if(session==null)
		{
			throw new ServiceException("session not opened");
		}
		int employeeId = (int) session.getAttribute("employeeId");
		emphourBean.setEmployeeId(employeeId);

		hourRepository.save(emphourBean);

		return true;
	}

	@Override
	public List<EmployeeHoursBean> getMonthlyHours(String month,HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(month);
		System.out.println(hourRepository.findByMonth(month));
		
		return hourRepository.findByMonth(month);
		
	}

}
