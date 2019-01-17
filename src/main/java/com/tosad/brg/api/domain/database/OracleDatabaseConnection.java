package com.tosad.brg.api.domain.database;

import com.tosad.brg.api.domain.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDatabaseConnection implements DatabaseConnection {
    Connection connection = null;


    public OracleDatabaseConnection(Project project) {
        try {
            connection = DriverManager.getConnection(
                    formatToConnectionString(project), project.getUsername(), project.getPasssword()
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

    private String formatToConnectionString(Project project) {
        return String.format("jdbc:oracle:thin:@//%s:%d/%s", project.getHost(), project.getPort(), "EDUC16");
    }
}
