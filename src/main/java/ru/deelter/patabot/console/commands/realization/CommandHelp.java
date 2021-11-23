package ru.deelter.patabot.console.commands.realization;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.commands.Command;
import ru.deelter.patabot.discord.bot.commands.utils.AbstractCommand;
import ru.deelter.patabot.discord.bot.commands.CommandManager;

public class CommandHelp extends Command {

    public CommandHelp(@NotNull String id) {
        super(id, "Show all commands");
    }

    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder("\nCommands list:").append("\n");
        for (Command command : ru.deelter.patabot.console.commands.CommandManager.getCommandMap().values()) {
            sb.append("| ")
                    .append(command.getId())
                    .append(" - ")
                    .append(command.getDescription())
                    .append("\n");
        }
        sb.append("\nBot commands list:").append("\n");
        for (AbstractCommand command : CommandManager.getCommandMap().values()) {
            sb.append("| ").append(command.getId()).append("\n");
        }

        ConsoleLogger.info(sb.toString());
    }
}
