package com.tosad.brm.web.dataAccess;

import com.tosad.brm.web.domain.project.Table;

import java.sql.Statement;
import java.util.List;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();

    Statement createStatement();

    List<Table> getSchema();
}
