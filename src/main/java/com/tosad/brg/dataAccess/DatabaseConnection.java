package com.tosad.brg.dataAccess;

import java.sql.Statement;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();

    Statement createStatement();
}
