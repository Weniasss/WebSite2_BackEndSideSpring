package com.example.Project2.controller;


import com.example.Project2.model.Employee;
import com.example.Project2.model.ProjectExample;
import com.example.Project2.services.EmployeeService;
import com.example.Project2.services.ProjectExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProjectExampleController {
    @Autowired

    private final ProjectExampleService projectExampleService;

    public ProjectExampleController(ProjectExampleService projectExampleService) {
        this.projectExampleService = projectExampleService;
    }

    @GetMapping("/projectExamples")
    public List<ProjectExample> getAllProjectExamples(){
        return projectExampleService.getAllProjectExamples();
    }

    @GetMapping("/projectExamples/{id}")
    public ResponseEntity<ProjectExample> getProjectExampleById(@PathVariable Long id){
        ProjectExample projectExample = null;
        projectExample = projectExampleService.getProjectExampleById(id);
        return ResponseEntity.ok(projectExample);
    }

}
