package ru.deelter.patabot.utils.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQL extends Database {

    private HikariDataSource dataSource;

    private final String name;
    private final String host;
    private final String username;
    private final String password;
    private final int port;

    public MySQL(@NotNull String databaseName, String name, String host, int port, String username, String password) {
        super(databaseName);
        this.name = name;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        setupPool();
    }

    private void setupPool() {
        HikariConfig config = new HikariConfig();
        try {
            config.setDriverClassName(Class.forName("com.mysql.cj.jdbc.Driver").getName());
        } catch (ClassNotFoundException e) {
            config.setDriverClassName("com.mysql.jdbc.Driver");
        }
        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + name + "?useSSL=false");
        config.setUsername(username);
        config.setPassword(password);
        dataSource = new HikariDataSource(config);
    }

    @Override
    public Connection openConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void closeConnection() {
        if (dataSource != null && !dataSource.isClosed()) dataSource.close();
    }
}
