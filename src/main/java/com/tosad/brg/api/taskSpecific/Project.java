package com.tosad.brg.api.taskSpecific;

import com.tosad.brg.api.infrastructure.DatabaseConnection;
import com.tosad.brg.api.domain.template.DatabaseType;

import java.util.ArrayList;

public class Project {
    private final DatabaseConnection databaseConnection;
    private String name;
    private String host;
    private String username;
    private String password;
    private int port;
    private DatabaseType databaseType;
    private ArrayList<Table> tables;

    public Project(String name, String host, String username, String password, int port, DatabaseType databaseType, ArrayList<Table> tables) {
        this.name = name;
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
        this.databaseType = databaseType;
        this.tables = tables;
        this.databaseConnection = databaseType.createConnection(host, username, password, port);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }
}
