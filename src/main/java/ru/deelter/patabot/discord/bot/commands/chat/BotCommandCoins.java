package ru.deelter.patabot.discord.bot.commands.chat;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.discord.bot.commands.BotCommand;
import ru.deelter.patabot.discord.users.money.CoinsDatabase;

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
            channel.sendMessage(user.getName() + ", сейчас у Вас " + coins + " монет").queue();
            return;
        }

        if (args.length != 2) return;

        int newBalance = Integer.parseInt(args[1]);
        if (args[0].equalsIgnoreCase("add")) {
            int newCoins = CoinsDatabase.getCoins(userId) + newBalance;

            CoinsDatabase.setCoins(userId, newCoins);
            channel.sendMessage(user.getName() + ", теперь у вас " + newCoins + " монет").queue();
        }

        else if (args[0].equalsIgnoreCase("set")) {
            CoinsDatabase.setCoins(userId, newBalance);
            channel.sendMessage(user.getName() + ", теперь у вас " + newBalance + " монет").queue();
        }
    }
}
