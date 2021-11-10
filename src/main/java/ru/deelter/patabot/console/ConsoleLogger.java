package ru.deelter.patabot.console;

import ru.deelter.patabot.utils.Color;

public class ConsoleLogger {

    private static boolean debug = true;

    public static void debug(String line) {
        if (debug) ConsoleManager.getLineReader().printAbove(Color.YELLOW + "DEBUG: " + line + Color.RESET);
    }

    public static void warn(String line) {
        ConsoleManager.getLineReader().printAbove(Color.YELLOW + "WARN: " + line + Color.RESET);
    }

    public static void error(String line) {
        ConsoleManager.getLineReader().printAbove(Color.RED + "ERROR: " + line + Color.RESET);
    }

    public static void info(String line) {
        ConsoleManager.getLineReader().printAbove(line);
    }
}
