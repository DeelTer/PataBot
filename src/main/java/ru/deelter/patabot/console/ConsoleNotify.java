package ru.deelter.patabot.console;

public class ConsoleNotify {

    private static boolean debug = true;

    public static void debug(String line) {
        if (debug) ConsoleManager.getLineReader().printAbove(ConsoleColors.YELLOW + "DEBUG: " + line);
    }

    public static void warn(String line) {
        ConsoleManager.getLineReader().printAbove(ConsoleColors.YELLOW + "WARN: " + line);
    }

    public static void error(String line) {
        ConsoleManager.getLineReader().printAbove(ConsoleColors.RED + "ERROR: " + line);
    }

    public static void info(String line) {
        ConsoleManager.getLineReader().printAbove(line);
    }
}