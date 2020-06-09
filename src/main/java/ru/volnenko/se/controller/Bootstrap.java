package ru.volnenko.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import java.util.logging.Logger;

/**
 * @author Denis Volnenko
 */
public final class Bootstrap implements ServiceLocator {

    private final ITaskRepository taskRepository;

    private final IProjectRepository projectRepository;

    private final IProjectService projectService;

    private final ITaskService taskService;

    private final IDomainService domainService;

    public Bootstrap(ITaskRepository taskRepository, IProjectRepository projectRepository,
                     IProjectService projectService, ITaskService taskService, IDomainService domainService) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.taskService = taskService;
        this.domainService = domainService;
    }

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

    private List<AbstractCommand> commandList;

    public List<AbstractCommand> getCommandList() {
        return commandList;
    }

    @Autowired
    public void setCommandList(List<AbstractCommand> commandList) {
        this.commandList = commandList;
    }

    public void registry(final AbstractCommand command) {
        final String cliCommand = command.command();
        final String cliDescription = command.description();
        if (cliCommand == null || cliCommand.isEmpty()) throw new CommandCorruptException();
        if (cliDescription == null || cliDescription.isEmpty()) throw new CommandCorruptException();
        command.setBootstrap(this);
        commands.put(cliCommand, command);
    }

    public void registry() {
        commandList.forEach(this::registry);
    }

    public void init() throws Exception {
        registry();
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
