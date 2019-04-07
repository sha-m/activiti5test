package com.example.activiti5.service;

public interface StaffService {

	public Integer queryStateByName(String name);

	public void updateState(Integer state,String name);

	public Integer queryByName(String name);

}
