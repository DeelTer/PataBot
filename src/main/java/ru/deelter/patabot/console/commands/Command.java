package ru.deelter.patabot.console.commands;

import org.jetbrains.annotations.NotNull;

public abstract class Command {

    private final String id;
    private String description;

    public Command(@NotNull String id, @NotNull String description) {
        this.id = id.toUpperCase();
        this.description = description;
    }

    public Command(@NotNull String id) {
        this(id, "Not specified");
    }

    protected abstract void execute(String[] args);

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public void register() {
        CommandManager.register(this);
    }
}
