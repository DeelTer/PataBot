package ru.deelter.patabot.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.Config;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    private static JDA discordBot;
    private static Guild guild;

    public static void load() {
        JDABuilder builder = JDABuilder.createDefault(Config.BOT_TOKEN)
                .disableCache(CacheFlag.EMOTE, CacheFlag.VOICE_STATE)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setActivity(Activity.watching(Config.BOT_ACTIVITY))
                .setEnabledIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
        try {
            discordBot = builder.build();
            discordBot.awaitReady();
        } catch (LoginException | InterruptedException exception) {
            exception.printStackTrace();
        }
        guild = discordBot.getGuildById(Config.GUILD_ID);
    }

    @NotNull
    public static JDA getBot() {
        return discordBot;
    }

    @NotNull
    public static Guild getGuild() {
        return guild;
    }
}
