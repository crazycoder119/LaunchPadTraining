package com.chandima.projectmanagment.taskservice.repository;

import com.chandima.projectmanagement.commons.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Modifying
    @Transactional
    @Query(value = "select projectmanagerdb.project.projectName, projectmanagerdb.project.projectManager, projectmanagerdb.project.startDate, projectmanagerdb.project.endDate, projectmanagerdb.task.taskName, projectmanagerdb.task.developer, projectmanagerdb.task.qa, projectmanagerdb.task.state, projectmanagerdb.task.asignedDate from projectmanagerdb.task inner join  projectmanagerdb.project on projectmanagerdb.project.projectName=projectmanagerdb.task.projectName where projectmanagerdb.task.projectName= ?1", nativeQuery = true)
    public List<Object> getAllTasksByProject(String project);
}
