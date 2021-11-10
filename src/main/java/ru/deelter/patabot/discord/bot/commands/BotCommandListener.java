package ru.deelter.patabot.discord.bot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.console.ConsoleLogger;

import java.util.ArrayList;
import java.util.List;

public class BotCommandListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        User user = event.getAuthor();
        if (user.isBot()) return;

        String rawMessage = event.getMessage().getContentRaw();
        if (rawMessage.length() < 1) return;

        String[] args = rawMessage.split(" ");
        if (args.length < 1) return;

        String label = args[0].toUpperCase();
        BotCommand command = BotCommandManager.getCommand(label);
        if (command == null) return;

        MessageChannel channel = event.getChannel();
        if (!command.isValidChannel(channel)) return;

        Member member = event.getMember();
        if (member == null) return;
        if (command.isAdminOnly() && !event.getMember().hasPermission(Permission.ADMINISTRATOR)) return;

        List<String> argsList = new ArrayList<>(List.of(args));
        argsList.remove(0);

        String[] argsWithoutFirst = argsList.toArray(new String[0]);
        command.execute(user, channel, argsWithoutFirst);

        if (command.needRemoveMessage()) event.getMessage().delete().queue();

        ConsoleLogger.debug(user.getName() + " used server command " + command.getId());
    }
}
