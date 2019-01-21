package com.tosad.brg.api.domain.template;

import com.tosad.brg.api.taskSpecific.Project;
import com.tosad.brg.api.infrastructure.DatabaseConnection;
import com.tosad.brg.api.infrastructure.OracleDatabaseConnection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "DATABASETYPE")

public enum DatabaseType implements Serializable {
    ORACLE("oracle") {
        @Override
        public DatabaseConnection createConnection(String host, String username, String password, int port) {
            return new OracleDatabaseConnection(host, username, password, port);
        }
    },
    UNKNOWN("unkown");

    private String type;

    @OneToMany(mappedBy="databasetype")
    Set<Project> projects;

    DatabaseType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public DatabaseConnection createConnection(String host, String username, String password, int port) {
        return null;
    }
}