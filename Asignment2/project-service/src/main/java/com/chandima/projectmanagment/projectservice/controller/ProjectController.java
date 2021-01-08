package com.chandima.projectmanagment.projectservice.controller;

import com.chandima.projectmanagement.commons.model.project.Project;
import com.chandima.projectmanagment.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    /**
     * Give user option to see tasks in a particuler project
     */
    @RequestMapping(value = "/getalltasksfromprojectName/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<Object[]>   getTasksByProjectId(@PathVariable int projectId){
        String baseURL = "http://localhost:9182/services/getAllTasksByProject/"+projectId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(baseURL, Object[].class);
        Object[] objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        return ResponseEntity.ok().body(objects);
    }

    /**
     * Implement to send the project object for service calls
     */
    @RequestMapping(value = "/projectvalidate/{id}", method = RequestMethod.GET)
    public Project getProjectByPROJECTiD(@PathVariable int id){
        return projectService.getProjectById(id);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ResponseEntity getProjectById(@PathVariable int id){
        Project updatedproject = projectService.getProjectById(id);
        if(updatedproject==null){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no any existing project with this id");
        }else{
            return  ResponseEntity.ok().body(updatedproject);
        }
    }

    @RequestMapping(value = "/addproject", method = RequestMethod.POST)
    public ResponseEntity addProject(@RequestBody Project project){
        Project updatedproject = projectService.addProject(project);
        if(updatedproject==null){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is an existing project already with the id");
        }else{
            return  ResponseEntity.ok().body(updatedproject);
        }
    }

    @RequestMapping(value = "/updateproject/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProjectById(@RequestBody Project project, @PathVariable int id){
        Project updatedproject = projectService.updateProjectById(id, project);
        if(updatedproject==null){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no project to update with the current id.");
        }else{
            return  ResponseEntity.ok().body(updatedproject);
        }
    }

    @RequestMapping(value = "/deleteproject/{id}/{admin}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProjectById(@PathVariable int id, @PathVariable String admin){
        if(admin.equals("admin")){
            Project updatedproject = projectService.deleteProjectById(id);
            if(updatedproject==null){
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no project to delete.");
            }
            return ResponseEntity.ok().body(updatedproject);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Please login as admin to delete project.");
    }
}
