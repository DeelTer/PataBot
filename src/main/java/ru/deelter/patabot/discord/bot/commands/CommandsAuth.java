package ru.deelter.patabot.discord.bot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.discord.bot.DiscordBot;
import ru.deelter.patabot.discord.bot.commands.utils.AbstractCommand;
import ru.deelter.patabot.discord.bot.commands.utils.ChatCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandsAuth extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        User user = event.getAuthor();
        if (user.isBot()) return;

        Message message = event.getMessage();
        String rawMessage = message.getContentRaw();
        if (rawMessage.length() < 1) return;
        if (!rawMessage.startsWith(DiscordBot.getPrefix())) return;

        rawMessage = rawMessage.substring(1); // Without prefix

        String[] args = rawMessage.split(" ");
        if (args.length < 1) return;

        String label = args[0].toUpperCase();
        AbstractCommand abstractCommand = CommandManager.getCommand(label);
        if (!(abstractCommand instanceof ChatCommand command)) return;
        if (command.needDeleteMessage()) event.getMessage().delete().queue();

        MessageChannel channel = event.getChannel();
        if (!command.isValidChannel(channel)) return;

        Member member = event.getMember();
        if (member == null) return;
        if (command.isAdminOnly() && !event.getMember().hasPermission(Permission.ADMINISTRATOR)) return;

        List<String> argsList = new ArrayList<>(List.of(args));
        argsList.remove(0);

        String[] argsWithoutFirst = argsList.toArray(new String[0]);
        command.execute(user, message, channel, argsWithoutFirst);
    }

    /*
    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        String commandId = event.getName();
        AbstractCommand abstractCommand = BotCommandManager.getCommand(commandId);
        if (!(abstractCommand instanceof SlashCommand command)) return;

        command.execute(event, user, event.getSubcommandGroup());
        event.reply("Гандон пошол нахуй.....").setEphemeral(true).queue(); // Queue both reply and edit
    }
     */
}
