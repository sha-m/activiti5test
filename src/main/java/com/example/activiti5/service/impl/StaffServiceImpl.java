package com.example.activiti5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activiti5.dao.StaffDao;
import com.example.activiti5.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public Integer queryStateByName(String name) {
		return staffDao.queryStateByName(name);
	}

	@Override
	public void updateState(Integer state,String name) {
		staffDao.updateState(state, name);
	}

	@Override
	public Integer queryByName(String name) {
		return staffDao.queryByName(name);
	}

}
