package ru.volnenko.se.api.service;

import ru.volnenko.se.entity.Task;

import java.util.Collection;
import java.util.List;

/**
 * @author Denis Volnenko
 */
public interface ITaskService {

    Task createTask(String name);

    Task getTaskById(String id);

    Task merge(Task task);

    void removeTaskById(String id);

    List<Task> getListTask();

    void clear();

    Task createTaskByProject(String projectId, String taskName);

    Task getByOrderIndex(Integer orderIndex);

    void merge(Task... tasks);

    void load(Task... tasks);

    void load(Collection<Task> tasks);

    void removeTaskByOrderIndex(Integer orderIndex);

}
