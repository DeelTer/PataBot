package ru.deelter.patabot.discord.bot.commands.chat;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.discord.bot.commands.BotCommand;

import java.awt.*;

public class BotCommandTest extends BotCommand {

    public BotCommandTest(String label) {
        super(label);
    }

    @Override
    protected void execute(@NotNull User user, @NotNull MessageChannel channel, @NotNull String[] args) {
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Color.orange)
                .setDescription("Пата-пата! " + user.getName())
                .setTitle("Пата-пата?");
        channel.sendMessageEmbeds(embed.build()).queue();
    }
}
