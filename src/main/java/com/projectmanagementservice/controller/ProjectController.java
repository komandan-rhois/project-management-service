package com.projectmanagementservice.controller;

import com.projectmanagementservice.dto.EmployeeResponse;
import com.projectmanagementservice.model.Employee;
import com.projectmanagementservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/employee")
public class ProjectController {
  @Autowired
  ProjectService projectService;

    @PostMapping("/getAllEmployee")
    public EmployeeResponse getAllLeader() {
        return projectService.getEmployee();
    }


  @PostMapping("/addprojectmember")
  public void addProjectMember(Employee employee, Long projectId) {
    projectService.addProjectMember(employee, projectId);
  }

  @PostMapping("/addprojectleader")
  public void addProjectLeader(Employee employee, Long projectId) {
    projectService.addProjectLeader(employee, projectId);
  }

//removeProjectById
  @PostMapping("/removeProjectById")
  public void removeProjectById(Long projectId) {
    projectService.removeProjectById(projectId);
  }

}
