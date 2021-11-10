package ru.deelter.patabot.utils.files;

import ru.deelter.patabot.console.ConsoleLogger;

import java.io.File;

public class PathManager {

    private static String mainPath;

    public static void setupPaths() {
        setupMainPath(); // Main directory
        DirectoryManager.createDirectory("money"); // ./money directory
    }

    public static void setupMainPath() {
        mainPath = new File(".").getPath();
        ConsoleLogger.info("Load main path: " + mainPath);
    }

    public static File getMainPathFile() {
        return new File(mainPath);
    }

    public static String getMainPath() {
        return mainPath;
    }
}
