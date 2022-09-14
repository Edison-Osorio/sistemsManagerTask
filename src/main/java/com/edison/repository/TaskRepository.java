package com.edison.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
