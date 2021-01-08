package com.chandima.projectmanagment.projectservice.repository;

import com.chandima.projectmanagement.commons.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Integer>{
}
