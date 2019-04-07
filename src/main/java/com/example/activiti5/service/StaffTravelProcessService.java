package com.example.activiti5.service;

import com.example.activiti5.bean.StaffTravelProcess;

public interface StaffTravelProcessService {

	void save(StaffTravelProcess process);

	StaffTravelProcess query(Integer tra_id);

	void update(StaffTravelProcess staffTravelProcess);

	void delete(Integer tra_id);
}
