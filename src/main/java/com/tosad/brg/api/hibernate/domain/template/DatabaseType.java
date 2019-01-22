package com.tosad.brg.api.hibernate.domain.template;

import com.tosad.brg.api.hibernate.infrastructure.DatabaseConnection;
import com.tosad.brg.api.hibernate.infrastructure.OracleDatabaseConnection;

import java.io.Serializable;

public enum DatabaseType implements Serializable {
    ORACLE("oracle") {
        @Override
        public DatabaseConnection createConnection(String host, String username, String password, int port) {
            return new OracleDatabaseConnection(host, username, password, port);
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