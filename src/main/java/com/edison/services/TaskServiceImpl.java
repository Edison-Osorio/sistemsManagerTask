package com.edison.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Task;
import com.edison.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> listTask() {
        List<Task> listTasks = taskRepository.findAll();
        return listTasks;
    }

    @Override
    public Task getOneTask(Long idTask) {
        Task task = taskRepository.findById(idTask).orElseThrow();
        return task;
    }

    @Override
    public Task addTask(Task task) {
        Task saveTask = taskRepository.save(task);
        return saveTask;
    }

    @Override
    public Task updateTask(Long idTask, Task task) {
        Task taskFound = taskRepository.findById(idTask).orElseThrow();

        taskFound.setNameTask(task.getNameTask());
        taskFound.setDescription(task.getDescription());
        taskFound.setStatus(task.getStatus());

        Task taskUpdating = taskRepository.save(taskFound);

        return taskUpdating;
    }

    @Override
    public Task deleteTask(Task task) {
        Task taskDelete = taskRepository.findById(task.getId()).orElseThrow();
        taskRepository.delete(taskDelete);
        return task;
    }

}
