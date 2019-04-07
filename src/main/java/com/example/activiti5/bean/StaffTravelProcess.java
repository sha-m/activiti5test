package com.example.activiti5.bean;

import lombok.Data;

@Data
public class StaffTravelProcess {
	private Integer tra_id;
	private String piid;
	private String pstep;
	//0表示未完成
	private Integer state;
}
