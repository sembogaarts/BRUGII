package com.tosad.brg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateUtils {
    public static SessionFactory factory;
    public static Session session;
    // to disallow creating objects by other classes.

    // maling the Hibernate SessionFactory object as singleton

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null || factory.isClosed()) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
            factory = meta.getSessionFactoryBuilder().build();
            session = factory.openSession();
        }
        return factory;
    }

    public static Session getSession() {
        if (session.isConnected()) {
            return session;
        } else {
            return factory.openSession();
        }
    }

    public static void close() {
        factory.close();
        session.close();
    }
}
