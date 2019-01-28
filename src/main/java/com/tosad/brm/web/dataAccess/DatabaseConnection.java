package com.tosad.brm.web.dataAccess;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();
}
