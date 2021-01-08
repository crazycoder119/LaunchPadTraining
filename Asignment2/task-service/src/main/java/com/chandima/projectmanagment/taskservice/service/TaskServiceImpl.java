package com.chandima.projectmanagment.taskservice.service;

import com.chandima.projectmanagement.commons.model.task.Task;
import com.chandima.projectmanagment.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()){
            return task.get();
        }
        return null;
    }

    @Override
    public Task addTask(Task task) {
        int id = task.getId();
        if(getTaskById(id)==null){
            return  taskRepository.save(task);
        }
        return null;
    }

    @Override
    public Task updateTaskById(int id, Task task) {
        Task existingTask = getTaskById(id);
        if(existingTask!=null){
            if(task.getTaskName()!=null){
                existingTask.setTaskName(task.getTaskName());
            }
            if(task.getProjectId()>0){
                existingTask.setProjectId(task.getProjectId());
            }
            if(task.getProjectName()!=null){
                existingTask.setProjectName(task.getProjectName());
            }
            if(task.getAsignedDate()!=null){
                existingTask.setAsignedDate(task.getAsignedDate());
            }
            if(task.getCompletedDate()!=null){
                existingTask.setCompletedDate(task.getCompletedDate());
            }
            if(task.getComments()!=null){
                existingTask.setComments(task.getComments());
            }
            if(task.getDeveloper()!=null){
                existingTask.setDeveloper(task.getDeveloper());
            }
            if(task.getQa()!=null){
                existingTask.setQa(task.getQa());
            }
            if(task.getState()!=null){
                existingTask.setState(task.getState());
            }
            return taskRepository.save(existingTask);
        }
        return null;
    }

    @Override
    public Task deleteTaskById(int id) {
        Task task = getTaskById(id);
        if (task != null){
            taskRepository.delete(task);
            return task;
        }
        return null;
    }

    @Override
    public List<Object> getAllTasksByProjectId(int projectId) {
        return taskRepository.getAllTasksByProjectId(projectId);
    }
}
