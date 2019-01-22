package com.tosad.brm.web.hibernate.infrastructure;

public interface DatabaseConnection {
    Object getConnection();

    void closeConnection();
}
