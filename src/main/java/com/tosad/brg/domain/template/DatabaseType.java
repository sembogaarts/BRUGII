package com.tosad.brg.domain.template;

import com.tosad.brg.dataAccess.DatabaseConnection;
import com.tosad.brg.dataAccess.MySQLDatabaseConnection;
import com.tosad.brg.dataAccess.OracleDatabaseConnection;
import com.tosad.brg.domain.type.TemplateTagType;

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

    public static DatabaseType getTypeByText(String type) {
        for (DatabaseType databaseType : values()) {
            if (databaseType.name.equals(type)) {
                return databaseType;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return name;
    }

    public DatabaseConnection createConnection(String host, String username, String password, int port) {
        return null;
    }
}