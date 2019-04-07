package com.example.activiti5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.activiti5.bean.StaffTravel;

public interface StaffTravelDao {

	@Insert("insert into t_staff_travel (staffName,travel,date,cost) values (#{staffName},#{travel},#{date},#{cost})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void save(StaffTravel staffTravel);

	@Select("select * from t_staff_travel where state = 0 and cost != 0 ")
	public List<StaffTravel> queryAllByStateEqualZeroAndCostNotZero();
	
	@Select("select * from t_staff_travel where (state = 0 or state = 2) and cost != 0 ")
	public List<StaffTravel> queryAllFM();

	@Select("select * from t_staff_travel where (state = 0 or state = 3) and cost != 0 ")
	public List<StaffTravel> queryAllPM();

	@Update("update t_staff_travel set state = 1 where id=#{id}")
	public void updateState(Integer id);

	@Select("select * from t_staff_travel where state = 0 and cost = 0")
	public List<StaffTravel> queryAllByStateAndCostEqualZero();
	
	@Update("update t_staff_travel set state = 3 where id=#{id}")
	public void updateStateFM(Integer id);
	
	@Update("update t_staff_travel set state = 2 where id=#{id}")
	public void updateStatePM(Integer id);

}
