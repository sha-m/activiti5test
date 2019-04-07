package com.example.activiti5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activiti5.bean.StaffTravelProcess;
import com.example.activiti5.dao.StaffTravelProcessDao;
import com.example.activiti5.service.StaffTravelProcessService;

@Service
public class StaffTravelProcessServiceImpl implements StaffTravelProcessService{

	@Autowired
	private StaffTravelProcessDao staffTravelProcessDao;

	@Override
	public void save(StaffTravelProcess process) {
		staffTravelProcessDao.save(process);
	}

	@Override
	public StaffTravelProcess query(Integer tra_id) {
		return staffTravelProcessDao.query(tra_id);
	}

	@Override
	public void update(StaffTravelProcess staffTravelProcess) {
		staffTravelProcessDao.update(staffTravelProcess);
	}

	@Override
	public void delete(Integer tra_id) {
		staffTravelProcessDao.delete(tra_id);
	}
	
	
}
