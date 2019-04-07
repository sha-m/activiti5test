package com.example.activiti5.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StaffDao {

	@Select("select state from t_staff where name=#{name}")
	Integer queryStateByName(String name);

	@Update("update t_staff set state=#{state} where name=#{name}")
	void updateState(@Param("state")Integer state, @Param("name")String name);

	@Select("select count(*) from t_staff where name=#{name}")
	Integer queryByName(String name);

}
