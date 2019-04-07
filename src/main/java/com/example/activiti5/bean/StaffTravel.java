package com.example.activiti5.bean;

import java.util.Date;

import lombok.Data;

@Data
public class StaffTravel {
	private Integer id;
	private String staffName;
	private Integer travel; 
	private Date date; 
	private Integer cost; 
	private Integer state; 
}
