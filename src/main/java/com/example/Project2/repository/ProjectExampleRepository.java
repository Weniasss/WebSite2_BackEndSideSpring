package com.example.Project2.repository;

import com.example.Project2.entity.ProjectExampleEntity;
import com.example.Project2.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectExampleRepository extends JpaRepository<ProjectExampleEntity,Long> {
}
