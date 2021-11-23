package ru.deelter.patabot.discord.bot.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.patabot.discord.bot.DiscordBot;
import ru.deelter.patabot.discord.bot.commands.chat.BotCommandTest;
import ru.deelter.patabot.discord.bot.commands.utils.AbstractCommand;
import ru.deelter.patabot.discord.bot.commands.utils.SlashCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static final Map<String, AbstractCommand> COMMAND_MAP = new HashMap<>();

    public static Map<String, AbstractCommand> getCommandMap() {
        return COMMAND_MAP;
    }

    public static void register(@NotNull AbstractCommand command) {
        String id = command.getId();
        COMMAND_MAP.put(id, command);
        if (command instanceof SlashCommand) DiscordBot.getJDA().upsertCommand(id, command.getDescription()).queue();
    }

    public static void unregister(@NotNull String id) {
        COMMAND_MAP.remove(id);
    }

    @Nullable
    public static AbstractCommand getCommand(@NotNull String commandId) {
        return COMMAND_MAP.get(commandId);
    }

    public static void setupCommands() {
        register(new BotCommandTest("test"));
    }
}
