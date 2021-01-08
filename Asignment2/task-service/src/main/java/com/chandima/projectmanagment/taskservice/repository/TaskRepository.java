package com.chandima.projectmanagment.taskservice.repository;

import com.chandima.projectmanagement.commons.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Modifying
    @Transactional
    @Query(value = "select * from projectmanagerdb.task  where projectmanagerdb.task.projectId= ?1", nativeQuery = true)
    public List<Object> getAllTasksByProjectId(int projectId);
}
