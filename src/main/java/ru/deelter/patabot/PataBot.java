package ru.deelter.patabot;

import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;
import ru.deelter.patabot.console.commands.CommandManager;
import ru.deelter.patabot.utils.Color;
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
        CommandManager.register("TEST", args -> ConsoleLogger.info(Color.RED + "Command test!"));
        CommandManager.register("RELOAD", args -> Config.reload()); // Config reload command

        CommandManager.register("RAM", args -> {
            Runtime runtime = Runtime.getRuntime();
            long freeMem = runtime.freeMemory() / 1024 / 1024;
            long totalMem = runtime.totalMemory() / 1024 / 1024;
            ConsoleLogger.info("RAM statistic: [" + freeMem + "/" + totalMem + "]");
        }); // Check RAM command
    }
}
