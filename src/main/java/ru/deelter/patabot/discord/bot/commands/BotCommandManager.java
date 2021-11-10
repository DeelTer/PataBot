package ru.deelter.patabot.discord.bot.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.patabot.discord.bot.commands.chat.BotCommandCoins;
import ru.deelter.patabot.discord.bot.commands.chat.BotCommandTest;

import java.util.HashMap;
import java.util.Map;

public class BotCommandManager {

    private static final Map<String, BotCommand> COMMAND_MAP = new HashMap<>();

    public static Map<String, BotCommand> getCommandMap() {
        return COMMAND_MAP;
    }

    public static void register(@NotNull BotCommand command) {
        COMMAND_MAP.put(command.getId(), command);
    }

    public static void unregister(@NotNull String id) {
        COMMAND_MAP.remove(id);
    }

    @Nullable
    public static BotCommand getCommand(@NotNull String commandId) {
        return COMMAND_MAP.get(commandId);
    }

    public static void setupCommands() {
        register(new BotCommandTest("test"));
        register(new BotCommandCoins("coins"));
    }
}
