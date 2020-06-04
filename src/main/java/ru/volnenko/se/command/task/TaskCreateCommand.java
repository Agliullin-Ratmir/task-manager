package ru.volnenko.se.command.task;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
public final class TaskCreateCommand extends AbstractCommand {

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        bootstrap.getTaskRepository().createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
