package com.example.dpwo_backend.service;

import com.example.dpwo_backend.model.Task;
import com.example.dpwo_backend.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Task Service Tests")
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;
    private String taskId;

    @BeforeEach
    void setUp() {
        taskId = "1";
        task = new Task();
        task.setId(taskId);
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        task.setCompleted(false);
        task.setCreatedAt(LocalDateTime.now());
        task.setUserId("user1");
    }

    @Test
    @DisplayName("Should create a new task successfully")
    void createTask_ShouldReturnCreatedTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask(task);

        assertNotNull(createdTask);
        assertEquals(task.getTitle(), createdTask.getTitle());
        assertEquals(task.getDescription(), createdTask.getDescription());
        assertNotNull(createdTask.getCreatedAt());
        verify(taskRepository).save(any(Task.class));
    }

    @Test
    @DisplayName("Should retrieve all tasks for a specific user")
    void getTasksByUserId_ShouldReturnTasksList() {
        List<Task> tasks = Arrays.asList(task);
        when(taskRepository.findByUserId("user1")).thenReturn(tasks);

        List<Task> result = taskService.getTasksByUserId("user1");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(task.getTitle(), result.get(0).getTitle());
    }

    @Test
    @DisplayName("Should update an existing task with new values")
    void updateTask_ShouldReturnUpdatedTask() {
        Task updatedTask = new Task();
        updatedTask.setTitle("Updated Task");
        updatedTask.setDescription("Updated Description");
        updatedTask.setCompleted(true);

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        Task result = taskService.updateTask(taskId, updatedTask);

        assertNotNull(result);
        assertEquals(updatedTask.getTitle(), result.getTitle());
        assertEquals(updatedTask.getDescription(), result.getDescription());
        assertTrue(result.isCompleted());
    }

    @Test
    @DisplayName("Should delete a task by ID")
    void deleteTask_ShouldCallRepositoryDelete() {
        taskService.deleteTask(taskId);
        verify(taskRepository).deleteById(taskId);
    }

    @Test
    @DisplayName("Should retrieve a task by ID when it exists")
    void getTaskById_ShouldReturnTask() {
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(taskId);

        assertNotNull(result);
        assertEquals(task.getTitle(), result.getTitle());
        assertEquals(task.getDescription(), result.getDescription());
    }

    @Test
    @DisplayName("Should throw exception when task with given ID doesn't exist")
    void getTaskById_ShouldThrowException_WhenTaskNotFound() {
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> taskService.getTaskById(taskId));
    }
} 