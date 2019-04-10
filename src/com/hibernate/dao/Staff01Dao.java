package com.hibernate.dao;


import com.hibernate.entity.Department01;
import com.hibernate.entity.Staff01;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Acthor:孙琪; date:2019/4/9;
 */
public class Staff01Dao {
    SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
    Session session;

    @Before
    public void before() {
        session=sessionFactory.openSession();
        session.beginTransaction();
    }

    @After
    public void after() {
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void addStaff01AndDepartment01(){
        Department01 department01 = new Department01();
        department01.setDname("技术部");
        session.save(department01);
        Staff01 s1 =  new Staff01();
        s1.setSname("张三1");
        s1.setDepartment01(department01);
        Staff01 s2 =  new Staff01();
        s2.setSname("李四1");
        s2.setDepartment01(department01);
//        department01.getSet().add(s1);
//        department01.getSet().add(s2);
        session.save(s1);
        session.save(s2);
    }
    @Test
    public void queryClasses() {
        Staff01 s = session.get(Staff01.class, 1);
        System.out.println(s);
    }
}
