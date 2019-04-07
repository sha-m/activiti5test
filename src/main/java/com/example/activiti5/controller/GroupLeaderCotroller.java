package com.example.activiti5.controller;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
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
@RequestMapping("/groupLeader")
public class GroupLeaderCotroller {

	@Autowired
	private StaffTravelService staffTravelService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private StaffTravelProcessService staffTravelProcessService;
	
	@RequestMapping("/index")
	public String staff(Model model) {
		List<StaffTravel> list = staffTravelService.queryAllByStateAndCostEqualZero();
		model.addAttribute("staffTravel",list);
		return "groupLeader";
	}
	
	
	@RequestMapping("/agree")
	public String agree(Integer tra_id) {
		StaffTravelProcess process = staffTravelProcessService.query(tra_id);
		Task task = taskService.createTaskQuery().processInstanceId(process.getPiid()).singleResult();
		taskService.setVariable(task.getId(), "flag", true);
		taskService.setVariable(task.getId(), "tra_id", tra_id);
		taskService.complete(task.getId());
		return "redirect:/groupLeader/index";
	}

	
	@RequestMapping("/refuse")
	public String refuse(Integer tra_id) {
		StaffTravelProcess process = staffTravelProcessService.query(tra_id);
		Task task = taskService.createTaskQuery().processInstanceId(process.getPiid()).singleResult();
		taskService.setVariable(task.getId(), "flag", false);
		taskService.setVariable(task.getId(), "tra_id", tra_id);
		taskService.complete(task.getId());
		return "redirect:/groupLeader/index";
	}
}
