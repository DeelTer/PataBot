package ru.deelter.patabot.utils.database;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite extends Database {

    private File dataFolder;
    private final File folder;

    public SQLite(@NotNull String databaseName, @NotNull File folder) {
        super(databaseName);
        this.folder = folder;
        setup();
    }

    private void setup() {
        dataFolder = new File(folder, getDatabaseName() + ".db");
        if (!dataFolder.exists()) {
            try {
                if (!dataFolder.createNewFile()) System.out.println("Could not create a database file!");
            } catch (IOException e) {
                System.out.println("File write error: " + getDatabaseName() + ".db");
            }
        }
    }

    @Override
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + dataFolder);
    }

    @Override
    public void closeConnection() {
        // Nothing to close
    }
}
