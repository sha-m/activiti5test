package com.example.activiti5.listener;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;

import com.example.activiti5.common.ApplicationContextUtils;

public class SummaryListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		ApplicationContext applicationContext = ApplicationContextUtils.applicationContext;
		TaskService taskService = applicationContext.getBean(TaskService.class);	
		Task task = taskService.createTaskQuery().processInstanceId(execution.getProcessInstanceId()).singleResult();
		boolean flag = ((boolean) execution.getVariable("fmAdvice")) && ((boolean) execution.getVariable("pmAdvice"));
		taskService.setVariable(task.getId(), "flag", flag);
	}

}
