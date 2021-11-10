package ru.deelter.patabot.utils.files;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.PataBot;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ResourceManager {

    public static @NotNull File getFile(@NotNull String fileName) {
        URL resource = PataBot.class.getClassLoader().getResource(fileName);
        if (resource == null) throw new RuntimeException("File not found");
        return new File(resource.getFile());
    }

    public static @NotNull File saveResource(@NotNull String fileName) {
        File resourceFile = ResourceManager.getFile(fileName);
        File newFile = new File(PathManager.getMainPathFile() + fileName);
        try {
            FileUtils.copyFile(resourceFile, newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    public static void saveDefaultFiles() {
        saveResource("config.json");
    }
}
