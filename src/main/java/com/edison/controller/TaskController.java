package com.edison.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edison.entity.Task;
import com.edison.services.TaskService;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = { "*" })
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> listTasks() {
        List<Task> listTask = taskService.listTask();
        return listTask;
    }

    @GetMapping("/{idTask}")
    public Task getOneTask(@PathVariable(name = "idTask") Long idTask) {
        Task taskFound = taskService.getOneTask(idTask);
        return taskFound;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        Task taskAdd = taskService.addTask(task);
        return taskAdd;
    }

    @PutMapping("/{idTask}")
    public Task updateTask(@PathVariable(name = "idTask") Long idTask, @RequestBody Task task) {
        Task taskUpdating = taskService.updateTask(idTask, task);

        return taskUpdating;
    }

    @DeleteMapping("/{idTask}")
    public Task deleteTask(@PathVariable(name = "idTask") Long idTask) {
        Task taskFound = taskService.getOneTask(idTask);
        Task taskDeleting = taskService.deleteTask(taskFound);
        return taskDeleting;
    }

}
