package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.utils.files.PathManager;
import ru.deelter.patabot.utils.files.ResourceManager;

import java.io.File;

public class Config {

    private static String BOT_TOKEN;

    public static void setup() {
        File configFile = getConfigFile();
    }

    public static void reload() {
        ConsoleLogger.info("Config reloaded");
        setup();
    }

    private static File getConfigFile() {
        return ResourceManager.getFile("config.json");
    }
}
