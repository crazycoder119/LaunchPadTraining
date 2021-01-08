package com.chandima.projectmanagment.taskservice.service;

import com.chandima.projectmanagement.commons.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    Task save(Task task);

    List<Task> getAllTasks();

    Task getTaskById(int id);

    Task addTask(Task task);

    Task updateTaskById(int id, Task task);

    Task deleteTaskById(int id);

    List<Object> getAllTasksByProject(String project);
}
