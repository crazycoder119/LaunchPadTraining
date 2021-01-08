package com.chandima.projectmanagment.taskservice.controller;

import com.chandima.projectmanagement.commons.model.project.Project;
import com.chandima.projectmanagement.commons.model.task.Task;
import com.chandima.projectmanagment.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/getAllTasksByProject/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAllTasksByProjectId(@PathVariable int projectId){
        return ResponseEntity.ok().body(taskService.getAllTasksByProjectId(projectId));
    }


    /**
     * take project object from project server by sending the id
     */
    @RequestMapping(value = "/getProjectfromtaskservice/{projectId}", method = RequestMethod.GET)
    public Project getProjectNameValid(@PathVariable int projectId){
        String baseURL = "http://localhost:9181/services/projectvalidate/"+projectId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(baseURL, Project.class);
    }


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity getTaskById(@PathVariable int id){
        Task updatedTask = taskService.getTaskById(id);
        if(updatedTask==null){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no any existing task with this id");
        }else{
            return  ResponseEntity.ok().body(updatedTask);
        }
    }

    @RequestMapping(value = "/addtask", method = RequestMethod.POST)
    public ResponseEntity addTask(@RequestBody Task task){
        if(getProjectNameValid(task.getProjectId())!=null){
            Task updatedTask = taskService.addTask(task);
            if(updatedTask==null){
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is an existing task already");
            }else{
                return  ResponseEntity.ok().body(updatedTask);
            }
        }
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no project with this id to asign the task");
    }

    @RequestMapping(value = "/updatetask/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTaskById(@RequestBody Task task, @PathVariable int id){
        if(getProjectNameValid(task.getProjectId())!=null){
            Task updatedTask = taskService.updateTaskById(id, task);
            if(updatedTask==null){
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is an existing task already");
            }else{
                return  ResponseEntity.ok().body(updatedTask);
            }
        }
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no project with this id to asign the task");
    }

    @RequestMapping(value = "/deletetask/{id}/{admin}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTaskById(@PathVariable int id, @PathVariable String admin){
        if(admin.equals("admin")){
                Task updatedTask = taskService.deleteTaskById(id);
                if(updatedTask==null){
                    return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no task to delete.");
                }else{
                    return ResponseEntity.ok().body(updatedTask);
                }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Please login as admin to delete task.");
    }
}
