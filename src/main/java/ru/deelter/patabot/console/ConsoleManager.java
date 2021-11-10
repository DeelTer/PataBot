package ru.deelter.patabot.console;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import ru.deelter.patabot.console.commands.CommandManager;

import java.io.IOException;

public class ConsoleManager {

    private static Terminal terminal;
    private static LineReader lineReader;

    public static void setupConsole() {
        setupLineReader();
        CommandManager.runCommandProcessor();
        CommandManager.setupCommands();
    }

    public static void setupLineReader() {
        try {
            terminal = TerminalBuilder.builder().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lineReader = LineReaderBuilder.builder().terminal(terminal).build();
    }

    public static LineReader getLineReader() {
        return lineReader;
    }

    public static Terminal getTerminal() {
        return terminal;
    }
}
