package com.jhost.template.Template.service;

import com.jhost.template.Template.model.Task;
import com.jhost.template.Template.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Task> GetTasksByUserId(long userid)
    {

        return tasksRepository.findByUserid(userid);
    }

    public long CreateTaskByUserId(Task task)
    {
        var createdTask = tasksRepository.save(task);

        return createdTask.getTaskid();

    }

    public long UpdateTaskByUserId(Task task)
    {
        var createdTask = tasksRepository.save(task);

        return createdTask.getTaskid();

    }

    public void DeleteTaskByLstId(List<Long> lstTaskId)
    {
        tasksRepository.deleteAllById(lstTaskId);
    }
}
