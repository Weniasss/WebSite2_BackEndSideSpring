package com.example.Project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjectExample {
    private long id;
    private String titleProject;
    private String technologyProject;
    private String projectDescription;
}
