package ru.volnenko.se.command.data.xml;

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
public final class DataXmlClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "Remove XML file.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_XML);
        Files.deleteIfExists(file.toPath());
    }

    @EventListener(condition = "#commandEvent.command.toLowerCase().contains('data-xml-clear')")
    public void onApplicationEvent(CommandEvent commandEvent) throws Exception {
        execute();
    }
}
