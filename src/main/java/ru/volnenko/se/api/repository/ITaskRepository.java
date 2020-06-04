package ru.volnenko.se.api.repository;

import ru.volnenko.se.entity.Task;

import java.util.Collection;
import java.util.List;

/**
 * @author Denis Volnenko
 */
public interface ITaskRepository {

    Task createTask(String name);

    Task getTaskById(String id);

    Task getByOrderIndex(Integer orderIndex);

    void merge(Task... tasks);

    void merge(Collection<Task> tasks);

    void load(Collection<Task> tasks);

    void load(Task... tasks);

    Task merge(Task task);

    void removeTaskById(String id);

    void removeTaskByOrderIndex(Integer orderIndex);

    List<Task> getListTask();

    void clear();

}
