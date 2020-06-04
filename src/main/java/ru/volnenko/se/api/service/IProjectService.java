package ru.volnenko.se.api.service;

import ru.volnenko.se.entity.Project;

import java.util.Collection;
import java.util.List;

/**
 * @author Denis Volnenko
 */
public interface IProjectService {

    Project createProject(String name);

    Project merge(Project project);

    Project getProjectById(String id);

    void removeProjectById(String id);

    List<Project> getListProject();

    void clear();

    void merge(Project... projects);

    void load(Collection<Project> projects);

    void load(Project... projects);

    Project removeByOrderIndex(Integer orderIndex);

}
