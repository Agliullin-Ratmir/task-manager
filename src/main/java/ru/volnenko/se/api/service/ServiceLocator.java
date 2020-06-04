package ru.volnenko.se.api.service;

/**
 * @author Denis Volnenko
 */
public interface ServiceLocator {

    IProjectService getProjectService();

    ITaskService getTaskService();

    IDomainService getDomainService();

}
