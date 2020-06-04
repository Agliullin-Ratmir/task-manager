package ru.volnenko.se.command.data.bin;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.constant.DataConstant;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.entity.Task;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author Denis Volnenko
 */
public final class DataBinaryLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "Save data to binary file.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY LOAD]");
        final FileInputStream fileInputStream = new FileInputStream(DataConstant.FILE_BINARY);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        loadProjects(objectInputStream.readObject());
        loadTasks(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("[OK]");
    }

    private void loadProjects(final Object value) {
        if (!(value instanceof Project[])) return;
        final Project[] projects = (Project[]) value;
        bootstrap.getProjectService().load(projects);
    }

    private void loadTasks(final Object value) {
        if (!(value instanceof Task[])) return;
        final Task[] tasks = (Task[]) value;
        bootstrap.getTaskService().load(tasks);
    }

}
