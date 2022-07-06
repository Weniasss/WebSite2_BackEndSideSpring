package com.example.Project2.services;

import com.example.Project2.model.ProjectExample;

import java.util.List;

public interface ProjectExampleService {
    List<ProjectExample> getAllProjectExamples();
    ProjectExample getProjectExampleById(Long id);
}
