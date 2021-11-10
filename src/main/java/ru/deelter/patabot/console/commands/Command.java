package ru.deelter.patabot.console.commands;

import org.jetbrains.annotations.NotNull;

public interface Command {

    void execute(String[] args);

    default void register(@NotNull String id) {
        CommandManager.register(id, this);
    }
}
