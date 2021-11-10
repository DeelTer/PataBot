package ru.deelter.patabot.discord.users.money;

import org.jetbrains.annotations.NotNull;
import ru.deelter.patabot.PataBot;
import ru.deelter.patabot.utils.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinsDatabase {

    private static final Database DATABASE = Database.setupDatabase("coins");
    private static final String COINS_TABLE = "Coins";

    public static void setupTables() {
        try (Connection con = DATABASE.openConnection()){
            con.prepareStatement("CREATE TABLE IF NOT EXISTS `" + COINS_TABLE + "`("
                            + "`ID` varchar(64) PRIMARY KEY,"
                            + "`COUNT` int NOT NULL" + ");")
                    .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setCoins(@NotNull String id, int coins) {
        synchronized (PataBot.class) {
            String sql = "INSERT OR REPLACE INTO " + COINS_TABLE + "(ID,COUNT) VALUES(?,?);";
            try (Connection con = DATABASE.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.setInt(2, coins);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getCoins(@NotNull String id) {
        synchronized (PataBot.class) {
            String sql = "SELECT * FROM " + COINS_TABLE + " WHERE ID = '" + id + "';";
            try (Connection con = DATABASE.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) return rs.getInt("COUNT");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
