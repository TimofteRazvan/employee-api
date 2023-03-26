package com.example.FirstSpring.Controller;

import com.example.FirstSpring.Entity.EmployeeProject;
import com.example.FirstSpring.Service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class EmployeeProjectController {
    @Autowired
    EmployeeProjectService employeeProjectService;

    @GetMapping("/employees-projects")
    public List<EmployeeProject> findAllEmployeeProjects() {
        return employeeProjectService.findAllEmployeeProjects();
    }

    @PostMapping("/employees-projects")
    public void createEmployeeProject(@RequestBody EmployeeProject employeeProject) {
        employeeProjectService.createEmployeeProject(employeeProject);
    }
}
