package com.tosad.brg.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatabaseConnection implements DatabaseConnection {
    Connection connection = null;


    public MysqlDatabaseConnection(String host, String username, String password) {
        try {
            connection = DriverManager.getConnection(
                    formatToConnectionString(host), username, password
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

    private String formatToConnectionString(String host) {
        return String.format("jdbc:mysql:@//%s:%d", host);
    }
}
