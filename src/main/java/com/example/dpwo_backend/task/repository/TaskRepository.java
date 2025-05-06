package com.example.dpwo_backend.task.repository;

import com.example.dpwo_backend.task.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByUserId(String userId);
    List<Task> findByUserIdAndCompleted(String userId, boolean completed);
} 