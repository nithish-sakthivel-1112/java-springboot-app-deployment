package com.example.taskmanager.task;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final ConcurrentHashMap<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public TaskService() {
        reset();
    }

    void reset() {
        tasks.clear();
        nextId.set(1);

        create("Learn Spring Boot");
        create("Build a Maven package");
    }

    public List<Task> findAll() {
        return tasks.values().stream()
                .sorted(Comparator.comparing(Task::id))
                .toList();
    }

    public Task findById(long id) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    public Task create(String title) {
        long id = nextId.getAndIncrement();
        Task task = new Task(id, title, false);
        tasks.put(id, task);
        return task;
    }

    public void delete(long id) {
        if (tasks.remove(id) == null) {
            throw new TaskNotFoundException(id);
        }
    }
}
