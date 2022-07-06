package com.example.Project2.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "projectExample")
public class ProjectExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titleProject;
    private String technologyProject;
    private String projectDescription;
}
