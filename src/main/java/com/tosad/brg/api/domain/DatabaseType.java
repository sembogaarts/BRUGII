package com.tosad.brg.api.domain;

import com.tosad.brg.api.domain.database.DatabaseConnection;
import com.tosad.brg.api.domain.database.OracleDatabaseConnection;

import java.io.Serializable;

public enum DatabaseType implements Serializable {
    ORACLE("oracle") {
        @Override
        public DatabaseConnection createConnection(Project project) {
            return new OracleDatabaseConnection(project);
        }
    },
    UNKNOWN("unkown");

    private String type;

    DatabaseType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public DatabaseConnection createConnection(Project project) {
        return null;
    }
}