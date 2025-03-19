package com.example.dpwo_backend.controller;

import com.example.dpwo_backend.dto.task.TaskRequest;
import com.example.dpwo_backend.dto.task.TaskResponse;
import com.example.dpwo_backend.mapper.TaskMapper;
import com.example.dpwo_backend.model.Task;
import com.example.dpwo_backend.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskRequest, Authentication authentication) {
        Task task = taskMapper.toEntity(taskRequest);
        task.setUserId(authentication.getName());
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(taskMapper.toResponse(createdTask));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks(Authentication authentication) {
        List<Task> tasks = taskService.getTasksByUserId(authentication.getName());
        return ResponseEntity.ok(taskMapper.toResponseList(tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(taskMapper.toResponse(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable String id, @Valid @RequestBody TaskRequest taskRequest) {
        Task existingTask = taskService.getTaskById(id);
        Task updatedTask = taskMapper.updateEntity(existingTask, taskRequest);
        Task savedTask = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(taskMapper.toResponse(savedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
} 