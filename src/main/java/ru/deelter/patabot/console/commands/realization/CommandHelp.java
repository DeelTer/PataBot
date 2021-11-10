package ru.deelter.patabot.console.commands.realization;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.commands.Command;
import ru.deelter.patabot.console.commands.CommandManager;
import ru.deelter.patabot.discord.bot.commands.BotCommand;
import ru.deelter.patabot.discord.bot.commands.BotCommandManager;

public class CommandHelp extends Command {

    public CommandHelp(@NotNull String id) {
        super(id, "Show all commands");
    }

    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder("Commands list:").append("\n");
        for (Command command : CommandManager.getCommandMap().values()) {
            sb.append("| ")
                    .append(command.getId())
                    .append(" - ")
                    .append(command.getDescription())
                    .append("\n");
        }
        sb.append("\nBot commands list:").append("\n");
        for (BotCommand command : BotCommandManager.getCommandMap().values()) {
            sb.append("| ").append(command.getId()).append(",");
        }

        ConsoleLogger.info(sb.toString());
    }
}
