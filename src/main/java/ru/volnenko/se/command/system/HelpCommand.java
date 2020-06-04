package ru.volnenko.se.command.system;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
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

}
