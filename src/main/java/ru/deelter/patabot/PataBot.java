package ru.deelter.patabot;

import ru.deelter.patabot.utils.Console;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.utils.files.PathManager;

public class PataBot {

    public static void main(String[] args) {
        ConsoleManager.setupConsole();
        setupModules();
        Console.info("Successfully loaded!");
    }

    public static void setupModules() {
        PathManager.setupPaths();
        Console.info("All modules loaded!");
    }
}
