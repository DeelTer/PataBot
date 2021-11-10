package ru.deelter.patabot.utils.files;

import java.io.File;

public class PathManager {

    private static final String MAIN_DIR = new File(".").getPath();

    public static File getDataFolder() {
        return new File(MAIN_DIR);
    }

    public static String getFolderPath() {
        return MAIN_DIR;
    }
}
