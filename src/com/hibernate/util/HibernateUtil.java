package com.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //大写代表常量
    private static SessionFactory SESSION_FACTORY = null;
    private static Session SESSION = null;

    static {
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        SESSION_FACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Configuration configuration = new Configuration().configure();
        SESSION_FACTORY = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static Session getSession() {
        SESSION = getSessionFactory().openSession();
        return SESSION;
    }

}
