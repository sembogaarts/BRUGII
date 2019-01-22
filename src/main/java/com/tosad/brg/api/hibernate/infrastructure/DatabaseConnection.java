package com.tosad.brg.api.hibernate.infrastructure;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();
}
