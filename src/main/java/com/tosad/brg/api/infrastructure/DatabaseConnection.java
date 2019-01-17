package com.tosad.brg.api.infrastructure;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();
}
