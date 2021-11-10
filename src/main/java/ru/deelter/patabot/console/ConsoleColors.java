package ru.deelter.patabot.console;

public class ConsoleColors {

    public static final String RESET = "\u001B[0m";

    public static final String BLACK = "\u001B[40m";
    public static final String RED = "\u001B[41m";
    public static final String GREEN = "\u001B[42m";
    public static final String YELLOW = "\u001B[43m";
    public static final String BLUE = "\u001B[44m";
    public static final String PURPLE = "\u001B[45m";
    public static final String CYAN = "\u001B[46m";
    public static final String WHITE = "\u001B[47m";

    public static String parse(String s) {
        return s.replace("&r", RESET).replace("&f", WHITE).replace("&4", RED).replace("&2", GREEN).replace("&e",YELLOW);
    }
}
