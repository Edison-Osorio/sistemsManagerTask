package com.edison.services;

import java.util.List;

import com.edison.entity.Task;

public interface TaskService {

    public List<Task> listTask();

    public Task getOneTask(Long idTask);

    public Task addTask(Task task);

    public Task updateTask(Long idTask, Task task);

    public Task deleteTask(Task task);

}
