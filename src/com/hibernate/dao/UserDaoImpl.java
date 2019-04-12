package com.hibernate.dao;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(User user) {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            session.save(user);
            session.beginTransaction().commit();
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        HibernateUtil.closeSession();
        return num;
    }
    @Test
    public void add() {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            for (int i=0;i<20;i++){
            User user = new User();
            user.setName("admin"+i);
            user.setSex("女");
            user.setAge(i*5+1);
            session.save(user);
            }
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        HibernateUtil.closeSession();
    }
    @Override
    public int update(User user) {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            session.update(user);
            session.beginTransaction().commit();
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        HibernateUtil.closeSession();
        return num;
    }

    @Override
    public int delete(User user) {
        Session session= HibernateUtil.getSession();
        int num = 1;
        try {
            session.delete(user);
            session.beginTransaction().commit();
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        HibernateUtil.closeSession();
        return num;
    }

    @Override
    public List<User> findAll() {
        Session session= HibernateUtil.getSession();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        HibernateUtil.closeSession();
        return list;
    }

    @Override
    public User findUserById(Integer id) {
        //利用session根据主键查询
        Session session= HibernateUtil.getSession();
        User user=session.get(User.class, id);
        HibernateUtil.closeSession();
        return user;
    }
    @Override
    public List<User> queryPageUser(int pageIndex,int pageCount){
        List<User> list  =  new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from User");
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
        HibernateUtil.closeSession();
        return list;
    }
    @Override
    // 分页  总页数
    public int pages(int pageCount){
        int pages = 1;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("select count(*) from User");
        // 总条数
        Number number = (Number)query.uniqueResult();
        session.getTransaction().commit();
        HibernateUtil.closeSession();

        pages = (number.intValue()+pageCount-1)/pageCount;
        return pages;
    }

}
