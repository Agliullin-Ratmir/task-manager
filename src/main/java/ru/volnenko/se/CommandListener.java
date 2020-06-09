package ru.volnenko.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.controller.Bootstrap;

@Component
public class CommandListener implements ApplicationListener<CommandEvent> {

    private Bootstrap bootstrap;
    @Autowired
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @EventListener
    @Async
    @Override
    public void onApplicationEvent(CommandEvent commandEvent) {
        try {
            bootstrap.execute(commandEvent.getCommand());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
