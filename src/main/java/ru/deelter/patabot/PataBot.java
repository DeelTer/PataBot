package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.utils.files.PathManager;
import ru.deelter.patabot.utils.files.ResourceManager;

public class PataBot {

    public static void main(String[] args) {
        ConsoleManager.setupConsole();

        PathManager.setupPaths();
       // ResourceManager.saveDefaultFiles();
        Config.setup();

        ConsoleLogger.info("Successfully loaded!");
    }
}
