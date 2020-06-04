package ru.volnenko.se.controller;

import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.api.service.IDomainService;
import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.api.service.ITaskService;
import ru.volnenko.se.api.service.ServiceLocator;
import ru.volnenko.se.command.*;
import ru.volnenko.se.error.CommandAbsentException;
import ru.volnenko.se.error.CommandCorruptException;
import ru.volnenko.se.repository.ProjectRepository;
import ru.volnenko.se.repository.TaskRepository;
import ru.volnenko.se.service.DomainService;
import ru.volnenko.se.service.ProjectService;
import ru.volnenko.se.service.TaskService;

import java.util.*;

/**
 * @author Denis Volnenko
 */
public final class Bootstrap implements ServiceLocator {

    private final ITaskRepository taskRepository = new TaskRepository();

    private final IProjectRepository projectRepository = new ProjectRepository();

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final ITaskService taskService = new TaskService(taskRepository, projectRepository);

    private final IDomainService domainService = new DomainService(this);

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private final Scanner scanner = new Scanner(System.in);

    public ITaskRepository getTaskRepository() {
        return taskRepository;
    }

    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public IProjectService getProjectService() {
        return projectService;
    }

    public ITaskService getTaskService() {
        return taskService;
    }

    public IDomainService getDomainService() {
        return domainService;
    }

    public void registry(final AbstractCommand command) {
        final String cliCommand = command.command();
        final String cliDescription = command.description();
        if (cliCommand == null || cliCommand.isEmpty()) throw new CommandCorruptException();
        if (cliDescription == null || cliDescription.isEmpty()) throw new CommandCorruptException();
        command.setBootstrap(this);
        commands.put(cliCommand, command);
    }

    public void registry(final Class... classes) throws InstantiationException, IllegalAccessException {
        for (Class clazz: classes) registry(clazz);
    }

    public void registry(final Class clazz) throws IllegalAccessException, InstantiationException {
        if (!AbstractCommand.class.isAssignableFrom(clazz)) return;
        final Object command = clazz.newInstance();
        final AbstractCommand abstractCommand = (AbstractCommand) command;
        registry(abstractCommand);
    }

    public void init(final Class... classes) throws Exception {
        if (classes == null || classes.length == 0) throw new CommandAbsentException();
        registry(classes);
        start();
    }

    private void start() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = scanner.nextLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) return;
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) return;
        abstractCommand.execute();
    }

    public List<AbstractCommand> getListCommand() {
        return new ArrayList<>(commands.values());
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public Integer nextInteger() {
        final String value = nextLine();
        if (value == null || value.isEmpty()) return null;
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }

}
