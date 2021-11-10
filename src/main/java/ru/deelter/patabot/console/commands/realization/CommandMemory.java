package ru.deelter.patabot.console.commands.realization;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.console.commands.Command;

public class CommandMemory extends Command {

    public CommandMemory(@NotNull String id) {
        super(id, "Memory check");
    }

    @Override
    public void execute(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long freeMem = runtime.freeMemory() / 1024 / 1024;
        long totalMem = runtime.totalMemory() / 1024 / 1024;

        String statistic =  "RAM statistic: [" + freeMem + "M/" + totalMem + "M]";
        ConsoleLogger.info(statistic);
    }
}
