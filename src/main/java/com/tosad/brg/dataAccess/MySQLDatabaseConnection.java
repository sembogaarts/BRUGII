package com.tosad.brg.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnection implements DatabaseConnection {
    Connection connection = null;


    public MySQLDatabaseConnection(String host, String username, String password, int port) {
        try {
            connection = DriverManager.getConnection(
                    formatToConnectionString(host, username, password, port)
            );
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    @Override
    public Object getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String formatToConnectionString(String host, String username, String password, int port) {
        String dbName = "target_db";
        return String.format(String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", host, port, dbName, username, password));
    }
}
