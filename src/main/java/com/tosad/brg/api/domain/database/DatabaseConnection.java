package com.tosad.brg.api.domain.database;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();
}
