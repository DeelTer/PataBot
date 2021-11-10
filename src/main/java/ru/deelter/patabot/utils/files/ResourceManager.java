package ru.deelter.patabot.utils.files;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.PataBot;

import java.io.File;
import java.net.URL;

public class ResourceManager {

    public static @NotNull File getFile(@NotNull String fileName) {
        URL resource = PataBot.class.getClassLoader().getResource(fileName);
        if (resource == null) throw new RuntimeException("File not found");
        return new File(resource.getFile());
    }
}
