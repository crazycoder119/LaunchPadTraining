package com.chandima.projectmanagment.taskservice.controller;

import com.chandima.projectmanagement.commons.model.Project;
import com.chandima.projectmanagement.commons.model.Task;
import com.chandima.projectmanagment.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/getAllTasksByProject/{project}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAllTasksByProject(@PathVariable String project){
        return ResponseEntity.ok().body(taskService.getAllTasksByProject(project));
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
        Task updatedTask = taskService.addTask(task);
        if(updatedTask==null){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is an existing task already");
        }else{
            return  ResponseEntity.ok().body(updatedTask);
        }
    }

    @RequestMapping(value = "/updatetask/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTaskById(@RequestBody Task task, @PathVariable int id){
        Task updatedTask  = taskService.updateTaskById(id, task);
        if(updatedTask==null){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is no task to update.");
        }else{
            return  ResponseEntity.ok().body(updatedTask);
        }
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
