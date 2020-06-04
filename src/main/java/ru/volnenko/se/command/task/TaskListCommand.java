package ru.volnenko.se.command.task;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Task;

/**
 * @author Denis Volnenko
 */
public final class TaskListCommand extends AbstractCommand {

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        int index = 1;
        for (Task task: bootstrap.getTaskRepository().getListTask()) {
            System.out.println(index + ". " + task.getName());
            index++;
        }
        System.out.println();
    }

}
