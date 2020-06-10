package ru.volnenko.se.command.system;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.CommandEvent;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
public final class HelpCommand extends AbstractCommand {

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (AbstractCommand command: bootstrap.getListCommand()) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }

    @EventListener(condition = "#commandEvent.command.toLowerCase().contains('help')")
    public void onApplicationEvent(CommandEvent commandEvent) {
        execute();
    }

}
