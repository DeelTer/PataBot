package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleNotify;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.utils.files.PathManager;

public class PataBot {

    public static void main(String[] args) {
        ConsoleManager.setupConsole();
        setupModules();
        ConsoleNotify.info("Successfully loaded!");
    }

    public static void setupModules() {
        PathManager.setupPaths();
        ConsoleNotify.info("All modules loaded!");
    }
}
