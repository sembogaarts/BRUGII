package com.tosad.brg.api.domain.template;

import com.tosad.brg.api.infrastructure.DatabaseConnection;
import com.tosad.brg.api.infrastructure.OracleDatabaseConnection;

import java.io.Serializable;

public enum DatabaseType implements Serializable {
    ORACLE("oracle") {
        @Override
        public DatabaseConnection createConnection(String host, String username, String password, int port) {
            return new OracleDatabaseConnection(host, username, password, port);
        }
    },
    UNKNOWN("unknown");

    private String name;

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