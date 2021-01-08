package com.chandima.projectmanagment.projectservice.service;

import com.chandima.projectmanagement.commons.model.project.Project;
import com.chandima.projectmanagment.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    /**
     * implemented to avoid null columns when update user can only give the update columns
     */
    @Override
    public Project updateProjectById(int id, Project project) {
        Project existingProject = getProjectById(id);
        if(existingProject!=null){
            if(project.getProjectName()!=null){
                existingProject.setProjectName(project.getProjectName());
            }
            if(project.getProjectManager()!=null){
                existingProject.setProjectManager(project.getProjectManager());
            }
            if(project.getStartDate()!=null){
                existingProject.setStartDate(project.getStartDate());
            }
            if(project.getEndDate()!=null){
                existingProject.setEndDate(project.getEndDate());
            }
            if(project.getStatus()!=null){
                existingProject.setStatus(project.getStatus());
            }
            return projectRepository.save(existingProject);
        }
        return null;
    }

    @Override
    public Project addProject(Project project) {
        int id = project.getId();
        if(getProjectById(id)==null){
           return  projectRepository.save(project);
        }
        return null;
    }

     public Project getProjectById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()){
            return project.get();
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project deleteProjectById(int id) {
        Project project = getProjectById(id);
        if (project != null){
            projectRepository.delete(project);
            return project;
        }
        return null;
    }
}
