package com.example.taskmanager.task;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(long id) {
        super("Task with ID " + id + " was not found");
    }
}
