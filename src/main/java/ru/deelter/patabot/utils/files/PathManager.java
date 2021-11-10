package ru.deelter.patabot.utils.files;

import java.io.File;

public class PathManager {

    private static final String MAIN_DIR = new File(".").getPath();

    public static File getMainDirFile() {
        return new File(MAIN_DIR);
    }

    public static String getMainDir() {
        return MAIN_DIR;
    }
}
