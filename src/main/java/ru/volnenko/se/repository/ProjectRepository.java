package ru.volnenko.se.repository;

import ru.volnenko.se.entity.Project;

import java.util.*;

/**
 * @author Denis Volnenko
 */
public final class ProjectRepository implements ru.volnenko.se.api.repository.IProjectRepository {

    private final Map<String, Project> map = new LinkedHashMap<>();

    @Override
    public Project createProject(final String name) {
        final Project project = new Project();
        project.setName(name);
        merge(project);
        return project;
    }

    @Override
    public Project merge(final Project project) {
        if (project == null) return null;
        map.put(project.getId(), project);
        return project;
    }

    @Override
    public void merge(final Collection<Project> projects) {
        if (projects == null) return;
        for (final Project project: projects) merge(project);
    }

    @Override
    public void merge(final Project... projects) {
        if (projects == null) return;
        for (final Project project: projects) merge(project);
    }

    @Override
    public void load(final Collection<Project> projects) {
        clear();
        merge(projects);
    }

    @Override
    public void load(final Project... projects) {
        clear();
        merge(projects);
    }

    @Override
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return map.get(id);
    }

    @Override
    public Project removeByOrderIndex(Integer orderIndex) {
        return null;
    }

    @Override
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }

    @Override
    public List<Project> getListProject() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

}
