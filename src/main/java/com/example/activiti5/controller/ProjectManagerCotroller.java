package com.example.activiti5.controller;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti5.bean.StaffTravel;
import com.example.activiti5.bean.StaffTravelProcess;
import com.example.activiti5.service.StaffTravelProcessService;
import com.example.activiti5.service.StaffTravelService;

@Controller
@RequestMapping("/projectManager")
public class ProjectManagerCotroller {

	@Autowired
	private StaffTravelService staffTravelService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private StaffTravelProcessService staffTravelProcessService;
	
	@RequestMapping("/index")
	public String staff(Model model) {
		List<StaffTravel> list = staffTravelService.queryAllPM();
		model.addAttribute("staffTravel",list);
		return "projectManager";
	}
	
	//pm操作后state变为2，fm操作后变为3
	@RequestMapping("/agree")
	public String agree(Integer tra_id) {
		StaffTravelProcess process = staffTravelProcessService.query(tra_id);
		List<Task> list = taskService.createTaskQuery().taskAssignee("王经理").list();
		for (Task task : list) {
			if (task.getProcessInstanceId().equals(process.getPiid())) {
				taskService.setVariable(task.getId(), "pmAdvice", true);
				taskService.setVariable(task.getId(), "tra_id", tra_id);
				staffTravelService.updateStatePM(tra_id);
				//完成事务的执行顺序晚于监听器
				taskService.complete(task.getId());				
				break;
			}
		}
		return "redirect:/projectManager/index";
	}

	
	@RequestMapping("/refuse")
	public String refuse(Integer tra_id) {
		StaffTravelProcess process = staffTravelProcessService.query(tra_id);
		List<Task> list = taskService.createTaskQuery().taskAssignee("王经理").list();
		for (Task task : list) {
			if (task.getProcessInstanceId().equals(process.getPiid())) {
				taskService.setVariable(task.getId(), "pmAdvice", false);
				taskService.setVariable(task.getId(), "tra_id", tra_id);
				staffTravelService.updateStatePM(tra_id);
				taskService.complete(task.getId());
				break;
			}
		}
		return "redirect:/projectManager/index";
	}
}
