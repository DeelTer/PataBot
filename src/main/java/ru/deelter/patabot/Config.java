package ru.deelter.patabot;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ru.deelter.patabot.console.ConsoleLogger;
import ru.deelter.patabot.utils.files.PathManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Config {

    public static String BOT_TOKEN;
    public static String BOT_ACTIVITY;

    public static String GUILD_ID;

    public static void setup() {
        File configFile = getConfigFile();
        Reader reader = null;
        try {
            reader = new FileReader(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //create JsonObject instance
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
        BOT_TOKEN = parser.get("token").getAsString();
        GUILD_ID = parser.get("guild-id").getAsString();
        BOT_ACTIVITY = parser.get("activity").getAsString();
    }

    public static void reload() {
        ConsoleLogger.info("Config reloaded");
        setup();
    }

    private static File getConfigFile() {
        return new File(PathManager.getDataFolder() + File.separator + "config.json");
    }
}
