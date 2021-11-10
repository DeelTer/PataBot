package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.utils.files.PathManager;

import java.io.File;

public class Config {

    private static String BOT_TOKEN;

    public static void setup() {
        File configFile = getConfigFile();
        System.out.println(configFile.isFile());
    }

    public static void reload() {
        ConsoleLogger.info("Config reloaded");
        setup();
    }

    private static File getConfigFile() {
        return new File(PathManager.getMainPathFile() + "config.json");
    }
}
