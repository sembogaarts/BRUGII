package com.tosad.brg.dataAccess;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();
}
