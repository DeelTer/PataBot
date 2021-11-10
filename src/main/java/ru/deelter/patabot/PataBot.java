package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;

public class PataBot {

    public static void main(String[] args) {
        ConsoleManager.setupConsole();
       // ResourceManager.saveDefaultFiles();
        Config.setup();

        ConsoleLogger.info("Successfully loaded!");
    }
}
