package com.example.activiti5.service;

import java.util.List;

import com.example.activiti5.bean.StaffTravel;

public interface StaffTravelService {

	void save(StaffTravel staffTravel);

	List<StaffTravel> queryAllByStateEqualZeroAndCostNotZero();

	void updateState(Integer id);

	List<StaffTravel> queryAllByStateAndCostEqualZero();

	List<StaffTravel> queryAllFM();

	List<StaffTravel> queryAllPM();

	void updateStatePM(Integer tra_id);
	
	void updateStateFM(Integer tra_id);

}
