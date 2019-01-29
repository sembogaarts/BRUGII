package com.tosad.brg.dataAccess;

import com.tosad.brg.domain.project.Table;

import java.sql.Statement;
import java.util.List;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();

    Statement createStatement();

    List<Table> getSchema();
}
