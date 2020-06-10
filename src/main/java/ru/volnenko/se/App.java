package ru.volnenko.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.volnenko.se.command.system.HelpCommand;

import ru.volnenko.se.controller.Bootstrap;


public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        final Bootstrap bootstrap = (Bootstrap) context.getBean("serviceLocator");
        bootstrap.init();
    }

}
