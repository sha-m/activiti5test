package com.example.activiti5.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.activiti5.bean.StaffTravelProcess;

public interface StaffTravelProcessDao {

	@Insert("insert into t_staff_travel_process (tra_id,piid,pstep,state) values (#{tra_id},#{piid},#{pstep},#{state})")
	void save(StaffTravelProcess process);

	@Select("select * from t_staff_travel_process where tra_id=#{tra_id}")
	StaffTravelProcess query(Integer tra_id);

	@Update("update t_staff_travel_process set pstep=#{pstep},state=#{state} where tra_id=#{tra_id}")
	void update(StaffTravelProcess staffTravelProcess);

	@Delete("delete from t_staff_travel_process where tra_id=#{tra_id}")
	void delete(Integer tra_id);

}
