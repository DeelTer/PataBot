package ru.deelter.patabot.console.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.ConsoleManager;

import java.util.*;

public class CommandManager {

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    public static Map<String, Command> getCommandMap() {
        return COMMAND_MAP;
    }

    public static void register(@NotNull Command command) {
        COMMAND_MAP.put(command.getId(), command);
    }

    public static void unregister(@NotNull String id) {
        COMMAND_MAP.remove(id);
    }

    @Nullable
    public static Command getCommand(@NotNull String commandId) {
        return COMMAND_MAP.get(commandId);
    }

    public static void runCommandProcessor() {
        Thread threadCommand = new Thread(() -> {
            while(true) {
                String line = ConsoleManager.getLineReader().readLine("> ");
                if (line.length() < 1) continue;

                String[] args = line.split(" ");
                if (args.length < 1) continue;

                Command command = CommandManager.getCommand(args[0].toUpperCase());
                if (command == null) {
                    ConsoleLogger.warn("Command not exists");
                    continue;
                }

                List<String> argsList = new ArrayList<>(List.of(args));
                argsList.remove(0);

                String[] argsWithoutFirst = argsList.toArray(new String[0]);
                command.execute(argsWithoutFirst);
            }
        });
        threadCommand.start();
    }
}
