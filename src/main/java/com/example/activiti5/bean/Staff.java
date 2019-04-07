package com.example.activiti5.bean;

import lombok.Data;

@Data
public class Staff {
	private Integer id;
	private String name;
	private char sex;
	//0表示可出差，1表示不能
	private Integer state;
}
