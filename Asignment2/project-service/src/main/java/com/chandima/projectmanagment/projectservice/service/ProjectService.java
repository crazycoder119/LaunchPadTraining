package com.chandima.projectmanagment.projectservice.service;

import com.chandima.projectmanagement.commons.model.project.Project;

import java.util.List;

public interface ProjectService {

    Project updateProjectById(int id, Project project);

    Project addProject(Project project);

    Project getProjectById(int id);

    List<Project> getAllProjects();

    Project deleteProjectById(int id);
}
