package ru.deelter.patabot.discord.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.Config;
import ru.deelter.patabot.discord.bot.commands.BotCommandListener;
import ru.deelter.patabot.discord.bot.commands.BotCommandManager;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    private static JDA jda;
    private static Guild guild;

    public static void enable() {
        setupJDA();
        guild = jda.getGuildById(Config.GUILD_ID);
        BotCommandManager.setupCommands();

        jda.upsertCommand("hello", "bruh").queue(); // This can take up to 1 hour to show up in the client
    }

    private static void setupJDA() {
        JDABuilder builder = JDABuilder.createDefault(Config.BOT_TOKEN)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setActivity(Activity.watching(Config.BOT_ACTIVITY))
                .addEventListeners(new BotCommandListener())
                .setEnabledIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
        try {
            jda = builder.build();
            jda.awaitReady();
        } catch (LoginException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @NotNull
    public static JDA getJDA() {
        return jda;
    }

    @NotNull
    public static Guild getGuild() {
        return guild;
    }
}
