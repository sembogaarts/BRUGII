package com.tosad.brg.domain.template;

import com.tosad.brg.dataAccess.DatabaseConnection;
import com.tosad.brg.dataAccess.MySQLDatabaseConnection;
import com.tosad.brg.dataAccess.OracleDatabaseConnection;

import java.io.Serializable;

public enum DatabaseType implements Serializable {
    ORACLE("oracle") {
        @Override
        public DatabaseConnection createConnection(String host, String username, String password, int port) {
            return new OracleDatabaseConnection(host, username, password, port);
        }
    },
    MYSQL("mysql") {
        @Override
        public DatabaseConnection createConnection(String host, String username, String password, int port) {
            return new MySQLDatabaseConnection(host, username, password, port);
        }
    },
    UNKNOWN("unknown");

    public String name;

    DatabaseType(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    public DatabaseConnection createConnection(String host, String username, String password, int port) {
        return null;
    }
}