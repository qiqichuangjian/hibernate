package com.hibernate.dao;

import com.hibernate.entity.Teacher01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * @Acthor:孙琪; date:2019/4/8;
 */
public class Teacher01Dao {
    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //====================
        //add
        Teacher01 teacher01 = new Teacher01();
        teacher01.settName("zhangsan");
        teacher01.settAge(31);
        teacher01.settSex("男");
        teacher01.settBorthday(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-08"));
        session.save(teacher01);
        //update
        teacher01 = session.get(Teacher01.class, 2);
        teacher01.settName("zhangsan");
        teacher01.settAge(31);
        teacher01.settSex("男");
        teacher01.settBorthday(new SimpleDateFormat("yyyy-MM-dd").parse("1977-04-08"));
        session.save(teacher01);
        //delete
        teacher01 = session.get(Teacher01.class, 3);
        if (teacher01 != null) {
            session.delete(teacher01);
        }
        //query
        // 查询的是对象（类名）
        String hql = "from Teacher01";
        Query query = session.createQuery(hql);
        List<Teacher01> list01 = query.list();
        //遍历需要toString才不会遍历出地址
        for (Teacher01 t01 : list01) {
            System.out.println(t01);
        }
        //=====================
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
