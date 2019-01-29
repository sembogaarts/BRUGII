package com.tosad.brg.dataAccess;

import com.tosad.brg.domain.project.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OracleDatabaseConnection implements DatabaseConnection {
    Connection connection = null;


    public OracleDatabaseConnection(String host, String username, String password, int port) {
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
        return String.format("jdbc:oracle:thin:@//%s:%d/%s", host, port, "EDUC16");
    }
}
