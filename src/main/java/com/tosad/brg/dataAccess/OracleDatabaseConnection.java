package com.tosad.brg.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDatabaseConnection implements DatabaseConnection {
    Connection connection = null;


    public OracleDatabaseConnection(String host, String username, String password, int port) {
        try {
            connection = DriverManager.getConnection(
                    formatToConnectionString(host, port), username, password
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

    private String formatToConnectionString(String host, int port) {
        return String.format("jdbc:oracle:thin:@//%s:%d/%s", host, port, "EDUC16");
    }
}
