package ru.volnenko.se;

import ru.volnenko.se.command.data.bin.DataBinaryClearCommand;
import ru.volnenko.se.command.data.bin.DataBinaryLoadCommand;
import ru.volnenko.se.command.data.bin.DataBinarySaveCommand;
import ru.volnenko.se.command.data.json.DataJsonClearCommand;
import ru.volnenko.se.command.data.json.DataJsonLoadCommand;
import ru.volnenko.se.command.data.json.DataJsonSaveCommand;
import ru.volnenko.se.command.data.xml.DataXmlClearCommand;
import ru.volnenko.se.command.data.xml.DataXmlLoadCommand;
import ru.volnenko.se.command.data.xml.DataXmlSaveCommand;
import ru.volnenko.se.command.project.ProjectClearCommand;
import ru.volnenko.se.command.project.ProjectCreateCommand;
import ru.volnenko.se.command.project.ProjectListCommand;
import ru.volnenko.se.command.project.ProjectRemoveCommand;
import ru.volnenko.se.command.system.HelpCommand;
import ru.volnenko.se.command.task.TaskClearCommand;
import ru.volnenko.se.command.task.TaskCreateCommand;
import ru.volnenko.se.command.task.TaskListCommand;
import ru.volnenko.se.command.task.TaskRemoveCommand;
import ru.volnenko.se.controller.Bootstrap;

public class App {

    private static final Class[] classes = {
            HelpCommand.class,
            ProjectClearCommand.class, ProjectCreateCommand.class,
            ProjectListCommand.class, ProjectRemoveCommand.class,
            TaskClearCommand.class, TaskCreateCommand.class,
            TaskListCommand.class, TaskRemoveCommand.class,
            DataBinaryLoadCommand.class, DataBinarySaveCommand.class,
            DataBinaryClearCommand.class, DataJsonSaveCommand.class,
            DataJsonLoadCommand.class, DataJsonClearCommand.class,
            DataXmlClearCommand.class, DataXmlLoadCommand.class,
            DataXmlSaveCommand.class
    };

    public static void main(String[] args) throws Exception {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(classes);
    }

}
