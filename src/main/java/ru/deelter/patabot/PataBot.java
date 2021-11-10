package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.console.commands.CommandManager;
import ru.deelter.patabot.console.commands.realization.CommandConfigReload;
import ru.deelter.patabot.console.commands.realization.CommandHelp;
import ru.deelter.patabot.console.commands.realization.CommandMemory;
import ru.deelter.patabot.utils.files.ResourceManager;

public class PataBot {

    public static void main(String[] args) {
        ConsoleManager.setupConsole();
        setupCommands();

        ResourceManager.saveResource("config.json", false);
        Config.setup();

        ConsoleLogger.info("Successfully loaded!");
    }

    private static void setupCommands() {
        CommandManager.register(new CommandConfigReload("reloadConfig"));
        CommandManager.register(new CommandMemory("mem"));
        CommandManager.register(new CommandHelp("help"));
    }
}
