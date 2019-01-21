package com.tosad.brg.api.infrastructure;

import com.tosad.brg.api.taskSpecific.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    private String formatToConnectionString(String host, int port) {
        return String.format("jdbc:oracle:thin:@//%s:%d/%s", host, port, "EDUC16");
    }
}
