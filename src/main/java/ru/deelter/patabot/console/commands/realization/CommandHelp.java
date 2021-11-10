package ru.deelter.patabot.console.commands.realization;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.commands.Command;
import ru.deelter.patabot.console.commands.CommandManager;

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
        ConsoleLogger.info(sb.toString());
    }
}
