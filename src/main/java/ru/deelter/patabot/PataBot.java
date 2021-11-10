package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.utils.files.PathManager;
import ru.deelter.patabot.utils.files.ResourceManager;

public class PataBot {

    public static void main(String[] args) {
        ResourceManager.saveDefaultFiles();
        ConsoleManager.setupConsole();
        setupModules();
        Config.setup();

        ConsoleLogger.info("Successfully loaded!");
    }

    public static void setupModules() {
        PathManager.setupPaths();
        ConsoleLogger.info("All modules loaded!");
    }
}
