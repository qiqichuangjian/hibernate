package com.hibernate.dao.daoImpl;

import com.hibernate.dao.StudentDao;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/12;
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public int add(Student s) {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            session.save(s);
            session.beginTransaction().commit();
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        session.close();
        return num;
    }

    @Override
    public int update(Student s) {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            session.update(s);
            session.beginTransaction().commit();
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        session.close();
        return num;
    }

    @Override
    public int delete(Student s) {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            session.delete(s);
            session.beginTransaction().commit();
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        session.close();
        return num;
    }

    @Override
    public Student queryOne(Integer id) {
        Session session= HibernateUtil.getSession();
        Student s=session.get(Student.class, id);
        session.close();
        return s;
    }

    @Override
    public List<Student> queryPage(int pageIndex, int pageCount) {
        List<Student> list  =  new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Student");
            // mysql 分页需要  索引和每页条数
            //索引
            query.setFirstResult((pageIndex-1)*pageCount);
            //每页条数
            query.setMaxResults(pageCount);

            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

    @Override
    public int pages(int pageCount) {
        //不管有没有数据，都有第一页
        int pages = 1;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("select count(*) from Student");
        // 总条数
        Number number = (Number)query.uniqueResult();
        pages = (number.intValue()+pageCount-1)/pageCount;

        session.getTransaction().commit();
        session.close();
        return pages;
    }
    @Test
    public void add() {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        int num = 1;
        try {
            for (int i=0;i<20;i++){
                Student user = new Student();
                user.setName("admin"+i);
                user.setSex("女");
                user.setAge(i*5+1);
                session.save(user);
            }
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        session.close();
    }
}
