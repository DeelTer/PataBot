package ru.deelter.patabot.discord.bot.commands.chat;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.discord.bot.commands.utils.ChatCommand;
import ru.deelter.patabot.discord.users.money.CoinsDatabase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BotCommandCoins extends ChatCommand {

    public BotCommandCoins(String id) {
        super(id);
    }

    @Override
    public void execute(@NotNull User user, @NotNull Message message, @NotNull MessageChannel channel, @NotNull String[] args) {

    }
//    @Override
//    public void execute(@NotNull User user, @NotNull Message message, @NotNull MessageChannel channel, @NotNull String[] args) {
//        if (args.length < 2) return;
//
//        if (args[0].equalsIgnoreCase("get")) {
//            List<Member> mentions = message.getMentionedMembers();
//            if (!mentions.isEmpty()) userId = mentions.get(0).getId();
//
//            int coins = CoinsDatabase.getCoins(userId);
//            channel.sendMessage( + coins + " монет").queue();
//            return;
//        }
//
//        int newBalance = Integer.parseInt(args[1]);
//        if (newBalance > 99999) return;
//        if (args[0].equalsIgnoreCase("add")) {
//            int newCoins = CoinsDatabase.getCoins(userId) + newBalance;
//
//            CoinsDatabase.setCoins(userId, newCoins);
//            channel.sendMessage(user.getName() + ", теперь у вас " + newCoins + " монет").queue();
//        }
//
//        else if (args[0].equalsIgnoreCase("set")) {
//            CoinsDatabase.setCoins(userId, newBalance);
//            channel.sendMessage(user.getName() + ", теперь у вас " + newBalance + " монет").queue();
//        }
//    }
}
