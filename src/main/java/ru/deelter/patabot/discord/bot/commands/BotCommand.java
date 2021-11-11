package ru.deelter.patabot.discord.bot.commands;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class BotCommand {

    private final List<String> channels = new ArrayList<>();

    private final String id;
    private boolean adminOnly = false;
    private boolean needDeleteMessage = true;

    private int answerDeleteSeconds = -1;

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

    public BotCommand enableChanel(@NotNull String...channelIds) {
        channels.addAll(Arrays.asList(channelIds));
        return this;
    }

    public boolean isValidChannel(@NotNull MessageChannel channel) {
        return channels.isEmpty() || channels.contains(channel.getId());
    }

    public boolean needDeleteMessage() {
        return needDeleteMessage;
    }

    public BotCommand deleteUserMessage(boolean needDeleteMessage) {
        this.needDeleteMessage = needDeleteMessage;
        return this;
    }

    public BotCommand deleteAnswerAfter(int answerDeleteSeconds) {
        this.answerDeleteSeconds = answerDeleteSeconds;
        return this;
    }

    public boolean needDeleteAnswer() {
        return answerDeleteSeconds > 0;
    }

    public int getAnswerDeleteSeconds() {
        return answerDeleteSeconds;
    }

    protected abstract void execute(@NotNull User user, @NotNull MessageChannel channel, @NotNull String[] args);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotCommand that = (BotCommand) o;
        return adminOnly == that.adminOnly && Objects.equals(id, that.id);
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
