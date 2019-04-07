package com.example.activiti5deploy;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleTest {

	ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	// ProcessEngine它提供了获取所有Activiti服务的方法(创建流程引擎)
	ProcessEngine processEngine = (ProcessEngine) ioc.getBean("processEngine");

	// 2.部署流程定义
	@Test
	public void test02() {
		// 获取流程定义和部署对象相关的Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// createDeployment()创建部署对象,addClasspathResource("mp.bpmn")加载资源文件，一次只能加载一个文件,deploy()//完成部署
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
		System.out.println("deploy=" + deploy);
	}

}
