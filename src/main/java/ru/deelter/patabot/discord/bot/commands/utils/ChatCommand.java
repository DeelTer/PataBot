package ru.deelter.patabot.discord.bot.commands.utils;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChatCommand extends AbstractCommand {

    private final List<String> channels = new ArrayList<>();

    private boolean needDeleteMessage = true;

    public ChatCommand(@NotNull String id, @NotNull String description) {
        super(id, description);
    }

    public ChatCommand(@NotNull String id) {
        super(id);
    }

    public List<String> getEnableChannels() {
        return channels;
    }

    public ChatCommand addChannels(@NotNull String...channelIds) {
        channels.addAll(Arrays.asList(channelIds));
        return this;
    }

    public boolean isValidChannel(@NotNull MessageChannel channel) {
        return channels.isEmpty() || channels.contains(channel.getId());
    }

    public boolean needDeleteMessage() {
        return needDeleteMessage;
    }

    public ChatCommand deleteUserMessage(boolean needDeleteMessage) {
        this.needDeleteMessage = needDeleteMessage;
        return this;
    }

    public abstract void execute(@NotNull User user, @NotNull Message message, @NotNull MessageChannel channel, @NotNull String[] args);
}
