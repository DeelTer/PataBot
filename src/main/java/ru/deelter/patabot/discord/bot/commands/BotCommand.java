package ru.deelter.patabot.discord.bot.commands;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BotCommand {

    private final List<String> channels = new ArrayList<>();

    private final String id;
    private boolean adminOnly = false;
    private boolean needRemoveMessage = true;

    public BotCommand(@NotNull String id) {
        this.id = id.toUpperCase();
    }

    public String getId() {
        return id;
    }

    public boolean isAdminOnly() {
        return adminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        this.adminOnly = adminOnly;
    }

    public List<String> getEnableChannels() {
        return channels;
    }

    public BotCommand channel(@NotNull String channelId) {
        channels.add(channelId);
        return this;
    }

    public boolean isValidChannel(@NotNull MessageChannel channel) {
        return channels.isEmpty() || channels.contains(channel.getId());
    }

    public boolean needRemoveMessage() {
        return needRemoveMessage;
    }

    public BotCommand removeMessage(boolean needRemoveMessage) {
        this.needRemoveMessage = needRemoveMessage;
        return this;
    }

    protected abstract void execute(@NotNull User user, @NotNull MessageChannel channel, @NotNull String[] args);

    public void register() {
        BotCommandManager.register(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotCommand that = (BotCommand) o;
        return adminOnly == that.adminOnly && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminOnly);
    }

    @Override
    public String toString() {
        return "BotCommand{" +
                "id='" + id + '\'' +
                ", adminOnly=" + adminOnly +
                '}';
    }
}
