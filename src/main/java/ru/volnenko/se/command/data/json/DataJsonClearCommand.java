package ru.volnenko.se.command.data.json;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.CommandEvent;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataJsonClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-clear";
    }

    @Override
    public String description() {
        return "Remove JSON file.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_JSON);
        Files.deleteIfExists(file.toPath());
    }

    @EventListener(condition = "#commandEvent.command.toLowerCase().contains('data-json-clear')")
    public void onApplicationEvent(CommandEvent commandEvent) throws Exception {
        execute();
    }
}
