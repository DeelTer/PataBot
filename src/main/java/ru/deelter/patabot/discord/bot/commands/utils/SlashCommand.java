package ru.deelter.patabot.discord.bot.commands.utils;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import org.jetbrains.annotations.NotNull;

public abstract class SlashCommand extends AbstractCommand {

    public SlashCommand(@NotNull String id, @NotNull String description) {
        super(id, description);
    }

    public SlashCommand(@NotNull String id) {
        super(id);
    }

    public abstract void execute(@NotNull SlashCommandEvent event, @NotNull User user, @NotNull MessageChannel channel, @NotNull String[] args);

}
