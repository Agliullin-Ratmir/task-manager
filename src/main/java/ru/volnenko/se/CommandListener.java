package ru.volnenko.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.controller.Bootstrap;

@Component
public class CommandListener implements ApplicationListener<CommandEvent> {

    private Bootstrap bootstrap;
    @Autowired
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Override
    public void onApplicationEvent(CommandEvent commandEvent) {
        try {
            execute(commandEvent.getCommand());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Async("workExecutor")
    void execute(final String command) throws Exception {
        System.out.println(Thread.currentThread().getId());
        if (command == null || command.isEmpty()) return;
        final AbstractCommand abstractCommand = bootstrap.getCommands().get(command);
        if (abstractCommand == null) return;
        abstractCommand.execute();
    }
}
