package com.hibernate.dao;

import com.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/8;
 */
public class TeacherDao {
    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //====================
         //add
        Teacher teacher=new Teacher();
        teacher.setName("zhangsan");
        teacher.setAge(31);
        teacher.setSex("男");
        teacher.setBorthday(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-08"));
        session.save(teacher);
        //update
        teacher=session.get(Teacher.class,1);
        teacher.setName("zhangsan");
        teacher.setAge(31);
        teacher.setSex("男");
        teacher.setBorthday(new SimpleDateFormat("yyyy-MM-dd").parse("1977-04-08"));
        session.save(teacher);
        //delete
        teacher=session.get(Teacher.class,2);
        if(teacher!=null){
            session.delete(teacher);
        }
        //query
        // 查询的是对象（类名）
        String hql="from Teacher";
        Query query = session.createQuery(hql);
        List<Teacher> list = query.list();
        //遍历需要toString才不会遍历出地址
        for (Teacher t:list) {
            System.out.println(t);
        }
        //=====================
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
