package ru.volnenko.se.command.data.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.constant.DataConstant;
import ru.volnenko.se.entity.Domain;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
public final class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-load";
    }

    @Override
    public String description() {
        return "Load Domain from XML.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[LOAD XML DATA]");
        final File file = new File(DataConstant.FILE_XML);
        if (!exists(file)) return;
        final byte[] bytes = Files.readAllBytes(file.toPath());
        final String json = new String(bytes, "UTF-8");
        final ObjectMapper objectMapper = new XmlMapper();
        final Domain domain = objectMapper.readValue(json, Domain.class);
        bootstrap.getDomainService().load(domain);
        System.out.println("[OK]");
    }

    private boolean exists(final File file) {
        if (file == null) return false;
        final boolean check = file.exists();
        if (!check) System.out.println("FILE NOT FOUND");
        return check;
    }

}
