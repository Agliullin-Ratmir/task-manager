package ru.volnenko.se.command.data.bin;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
public final class DataBinaryClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-clear";
    }

    @Override
    public String description() {
        return "Remove binary data.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
    }

}
