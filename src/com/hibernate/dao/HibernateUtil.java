package com.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * @Acthor:孙琪; date:2019/4/8;
 */
public class HibernateUtil {
    private static SessionFactory SESSIONFACTORY=null;
    static {
        //注册服务
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
        SESSIONFACTORY=new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }
    public static SessionFactory getSessionFactory(){

        return SESSIONFACTORY;
    }

}
