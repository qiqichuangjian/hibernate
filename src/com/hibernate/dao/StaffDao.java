package com.hibernate.dao;

import com.hibernate.entity.Department;
import com.hibernate.entity.Staff;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Acthor:孙琪; date:2019/4/9;
 */
public class StaffDao {
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
    public void addStaffAndDepartment(){
        Department department = new Department();
        department.setName("技术部");
        session.save(department);
        Staff s1 =  new Staff();
        s1.setName("张三");
        s1.setDepartment(department);
        Staff s2 =  new Staff();
        s2.setName("李四");
        s2.setDepartment(department);
        session.save(s1);
        session.save(s2);
    }
    @Test
    public void queryClasses() {
        Staff s = session.get(Staff.class, 2);
        System.out.println(s);
    }
}
