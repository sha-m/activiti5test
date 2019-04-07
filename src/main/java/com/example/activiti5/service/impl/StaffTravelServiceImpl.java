package com.example.activiti5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activiti5.bean.StaffTravel;
import com.example.activiti5.dao.StaffTravelDao;
import com.example.activiti5.service.StaffTravelService;

@Service
public class StaffTravelServiceImpl implements StaffTravelService{

	@Autowired
	private StaffTravelDao staffTravelDao;
	
	@Override
	public void save(StaffTravel staffTravel) {
		staffTravelDao.save(staffTravel);
	}

	@Override
	public List<StaffTravel> queryAllByStateEqualZeroAndCostNotZero() {
		return staffTravelDao.queryAllByStateEqualZeroAndCostNotZero();
	}

	@Override
	public void updateState(Integer id) {
		staffTravelDao.updateState(id);
	}

	@Override
	public List<StaffTravel> queryAllByStateAndCostEqualZero() {
		return staffTravelDao.queryAllByStateAndCostEqualZero();
	}

	@Override
	public List<StaffTravel> queryAllFM() {
		return staffTravelDao.queryAllFM();
	}

	@Override
	public List<StaffTravel> queryAllPM() {
		return staffTravelDao.queryAllPM();
	}

	@Override
	public void updateStatePM(Integer tra_id) {
		staffTravelDao.updateStatePM(tra_id);
	}

	@Override
	public void updateStateFM(Integer tra_id) {
		staffTravelDao.updateStateFM(tra_id);
	}

}
