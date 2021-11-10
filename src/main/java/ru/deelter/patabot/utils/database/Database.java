package ru.deelter.patabot.utils.database;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.utils.files.PathManager;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Database {

    private final String databaseName;

    public Database(@NotNull String name) {
        this.databaseName = name;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public Connection getConnection() throws SQLException {
        return openConnection();
    }

    public abstract Connection openConnection() throws SQLException;

    public abstract void closeConnection();

    /**
     * Setup MySQL or SQLite database
     *
     * @param databaseName name of database
     * @param plugin bukkit plugin
     * @param mySQL is MySQL database
     * @return database
     */
    @NotNull
    public static Database setupDatabase(@NotNull String databaseName) {
        return new SQLite(databaseName, PathManager.getMainDirFile());
    }
}
