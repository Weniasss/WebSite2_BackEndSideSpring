package com.example.Project2.services;

import com.example.Project2.model.ProjectExample;
import com.example.Project2.entity.ProjectExampleEntity;
import com.example.Project2.repository.ProjectExampleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectExampleServiceImpl implements ProjectExampleService {


    private ProjectExampleRepository projectExampleRepository;

    public ProjectExampleServiceImpl(ProjectExampleRepository projectExampleRepository){this.projectExampleRepository = projectExampleRepository; }

    @Override
    public List<ProjectExample> getAllProjectExamples() {

        List<ProjectExampleEntity> projectExampleEntities = projectExampleRepository.findAll();

        List<ProjectExample> projectExamples= projectExampleEntities.stream().map(emp -> new ProjectExample(
                emp.getId(),
                emp.getTitleProject(),
                emp.getTechnologyProject(),
                emp.getProjectDescription()))
                .collect(Collectors.toList());

        return projectExamples;
    }

    @Override
    public ProjectExample getProjectExampleById(Long id) {
        ProjectExampleEntity projectExampleEntity = projectExampleRepository.findById(id).get();
        ProjectExample projectExample = new ProjectExample();
        BeanUtils.copyProperties(projectExampleEntity,projectExample);
        return projectExample;
    }
}
