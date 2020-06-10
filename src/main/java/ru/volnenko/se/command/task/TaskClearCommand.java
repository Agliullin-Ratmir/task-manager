package ru.volnenko.se.command.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.CommandEvent;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
@DependsOn("taskRepository")
public final class TaskClearCommand extends AbstractCommand {

    private ITaskRepository taskRepository;

    @Autowired
    @Qualifier("taskRepository")
    public void setTaskRepository(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Override
    public void execute() {
        taskRepository.clear();
        System.out.println("[ALL TASK REMOVED]");
    }

    @EventListener(condition = "#commandEvent.command.toLowerCase().contains('task-clear')")
    public void onApplicationEvent(CommandEvent commandEvent) {
        execute();
    }
}
