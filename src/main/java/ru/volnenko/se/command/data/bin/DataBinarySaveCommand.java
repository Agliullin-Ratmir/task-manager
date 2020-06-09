package ru.volnenko.se.command.data.bin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.api.service.ITaskService;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.constant.DataConstant;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.entity.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
@Component
@DependsOn({"projectService", "taskService"})
public final class DataBinarySaveCommand extends AbstractCommand {

    private IProjectService projectService;

    private ITaskService taskService;
    @Autowired
    @Qualifier("projectService")
    public void setProjectService(IProjectService projectService) {
        this.projectService = projectService;
    }
    @Autowired
    @Qualifier("taskService")
    public void setTaskService(ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "Load data from binary file.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY SAVE]");
        final Project[] projects = projectService.getListProject().toArray(new Project[] {});
        final Task[] tasks = taskService.getListTask().toArray(new Task[] {});

        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());

        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("[OK]");
        System.out.println();
    }

}
