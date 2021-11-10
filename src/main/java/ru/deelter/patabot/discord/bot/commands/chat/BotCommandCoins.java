package ru.deelter.patabot.discord.bot.commands.chat;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.discord.bot.commands.BotCommand;
import ru.deelter.patabot.discord.users.money.CoinsDatabase;

import java.awt.*;

public class BotCommandCoins extends BotCommand {

    public BotCommandCoins(String label) {
        super(label);
    }

    @Override
    protected void execute(@NotNull User user, @NotNull MessageChannel channel, @NotNull String[] args) {
        if (args.length < 1) return;

        String userId = user.getId();
        if (args[0].equalsIgnoreCase("get")) {
            int coins = CoinsDatabase.getCoins(userId);
            channel.sendMessage("У вас " + coins + " монет").queue();
        }

        else if (args[0].equalsIgnoreCase("add")) {
            if (args.length != 2) return;

            int coinsAdd = Integer.parseInt(args[1]);
            int newCoins = CoinsDatabase.getCoins(userId) + coinsAdd;

            CoinsDatabase.setCoins(userId, newCoins);
            channel.sendMessage("Теперь у вас " + newCoins + " монет").queue();
        }
    }
}
