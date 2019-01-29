package com.tosad.brg.dataAccess;

import com.tosad.brg.domain.project.Table;

import java.sql.*;
import java.util.List;

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

    @Override
    public Statement createStatement() {
        return null;
    }

    @Override
    public List<Table> getSchema() {
        return null;
    }

    private String formatToConnectionString(String host, String username, String password, int port) {
        String dbName = "target_db";
        return String.format(String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", host, port, dbName, username, password));
    }

    public void executeQuery(String code) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
