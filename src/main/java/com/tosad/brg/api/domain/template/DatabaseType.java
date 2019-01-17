package com.tosad.brg.api.domain.template;

import com.tosad.brg.api.taskSpecific.Project;
import com.tosad.brg.api.infrastructure.DatabaseConnection;
import com.tosad.brg.api.infrastructure.OracleDatabaseConnection;

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