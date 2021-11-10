package ru.deelter.patabot;

import ru.deelter.patabot.utils.Color;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.console.commands.Command;
import ru.deelter.patabot.console.commands.CommandManager;
import ru.deelter.patabot.utils.files.ResourceManager;

public class PataBot {

    public static void main(String[] args) {
        ConsoleManager.setupConsole();
        setupCommands();
        Config.setup();

        ConsoleLogger.info("Successfully loaded!");
        ResourceManager.saveResource("config.json", false);
    }

    private static void setupCommands() {
        Command command = args -> ConsoleLogger.info(Color.RED + "Command test!");
        CommandManager.register("test", command);

        CommandManager.register("token", args -> ConsoleLogger.info("Bot token: " + Config.getBotToken()));
        CommandManager.register("guild", args -> ConsoleLogger.info("Guild ID: " + Config.getGuildId()));
        CommandManager.register("reload", args -> Config.reload());
    }
}
