package ru.deelter.patabot.discord.bot.commands.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class AbstractCommand {

    private final String id, description;
    private boolean adminOnly = false;

    public AbstractCommand(@NotNull String id, @NotNull String description) {
        this.id = id.toUpperCase();
        this.description = description;
    }

    public AbstractCommand(@NotNull String id) {
        this(id, "Not specified");
    }

    public @NotNull String getId() {
        return id;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public boolean isAdminOnly() {
        return adminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        this.adminOnly = adminOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCommand botCommand = (AbstractCommand) o;
        return Objects.equals(id, botCommand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BotCommand{" +
                "id='" + id + '\'' +
                ", adminOnly=" + adminOnly +
                '}';
    }
}
