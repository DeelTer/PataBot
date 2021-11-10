package ru.deelter.patabot.console.commands.realization;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.Config;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.commands.Command;
import ru.deelter.patabot.console.commands.CommandManager;

public class CommandConfigReload extends Command {

    public CommandConfigReload(@NotNull String id) {
        super(id, "Configuration reload");
    }

    @Override
    public void execute(String[] args) {
        Config.reload();
    }
}
