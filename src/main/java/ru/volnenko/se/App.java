package ru.volnenko.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        final Bootstrap bootstrap = (Bootstrap) context.getBean("serviceLocator");
        System.out.println(context.getBean(HelpCommand.class).hashCode());
        bootstrap.init();
    }

}
