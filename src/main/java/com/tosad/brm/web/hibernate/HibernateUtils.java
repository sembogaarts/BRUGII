package com.tosad.brm.web.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    public static SessionFactory factory;
    public static Session session;
    // to disallow creating objects by other classes.

    // maling the Hibernate SessionFactory object as singleton

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
            factory = meta.getSessionFactoryBuilder().build();
            session = factory.openSession();
        }
        return factory;
    }

    public Session getSession() {
        return session;
    }

    public void close() {
        factory.close();
        session.close();
    }
}
