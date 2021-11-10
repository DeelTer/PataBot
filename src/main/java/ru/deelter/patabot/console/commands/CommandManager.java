package ru.deelter.patabot.console.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.patabot.utils.Console;
import ru.deelter.patabot.console.ConsoleManager;

import java.util.*;

public class CommandManager {

    private static final Map<String, ConsoleCommand> COMMAND_MAP = new HashMap<>();

    public static void setupCommands() {
        register("TEST", args -> System.out.println("BRUH привет 12345"));
    }

    public static void register(@NotNull String id, @NotNull ConsoleCommand command) {
        COMMAND_MAP.put(id, command);
    }

    public static void unregister(@NotNull String id) {
        COMMAND_MAP.remove(id);
    }

    @Nullable
    public static ConsoleCommand getCommand(@NotNull String commandId) {
        return COMMAND_MAP.get(commandId);
    }

    public static void runCommandProcessor() {
        Thread threadCommand = new Thread(() -> {
            while(true) {
                String line = ConsoleManager.getLineReader().readLine("> ");

                String[] args = line.split(" ");
                ConsoleCommand command = CommandManager.getCommand(args[0].toUpperCase());
                if (command == null) {
                    Console.warn("Command not exists");
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
