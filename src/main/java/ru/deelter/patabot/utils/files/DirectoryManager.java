package ru.deelter.patabot.utils.files;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class DirectoryManager {

    @NotNull
    public static File createDirectory(@NotNull String dirName) {
        File directory = new File(PathManager.getDataFolder() + File.separator + dirName);
        if (!directory.exists()) directory.mkdir();
        return directory;
    }
}
