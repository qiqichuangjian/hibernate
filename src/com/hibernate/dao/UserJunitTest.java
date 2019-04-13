package com.hibernate.dao;

import com.hibernate.entity.User;
import com.hibernate.framework.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;



public class UserJunitTest {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Logger logger = Logger.getLogger(UserJunitTest.class);
    @Test
    public void add() {
        Session session = sessionFactory.openSession();
        int num = 1;
        try {
            for (int i=0;i<20;i++){
                User user = new User("admin"+i,"admin"+i);
                session.save(user);
            }
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        session.close();
    }

    /**
     * 投影查询  ，指定列名查询
     */
    @Test
    public void queryColunm(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //new User(username)里填什么就查询出什么，显示是通过toString显示在控制台的，所以不查询的列也会显示，不过不取值
        Query query = session.createQuery("select new User(username) from User");
        List<User> list = query.list();
        for (User user:list){
            System.out.println(user);
        }
    }

    /**
     * Sql 查询全部
     */
    @Test
    public void querySqlUser(){
        Session session = sessionFactory.openSession();
        String sql="select * from user";
        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        List<User> list = query.list();
        for (User user:list){
            System.out.println(user);
        }
    }

    /**
     *  sql投影查询
     */
    @Test
    public void querySqlColunm(){
        Session session = sessionFactory.openSession();
        String sql="select username,password from user ";
                                                //addScalar 获取单列信息
        NativeQuery query = session.createSQLQuery(sql).addScalar("username", StandardBasicTypes.STRING)
                .addScalar("password", StandardBasicTypes.STRING);
        List<Object[]> list = query.list();
        for (Object[] user:list){
            System.out.println(Arrays.toString(user));
        }
    }

    /**
     * QBC  查询
     */
    @Test
    public void queryQBCColunm(){
        Session session = sessionFactory.openSession();
        //addScalar 获取单列信息
        Criteria criteria = session.createCriteria(User.class).addOrder(Order.asc("id"));
        criteria.add(Restrictions.eq("id",1));
        List<User> list = criteria.list();
        for (User user:list){
            System.out.println(user);
        }
    }


    @Test
    public void queryGetAndLoad(){
        Session session = sessionFactory.openSession();

        User get = session.get(User.class, 1);
        User load = session.load(User.class, 2);
        System.out.println(get);
        System.out.println(load);
    }

    @Test
    public void queryGet(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = session.get(User.class, 1);
        User user1 = session.get(User.class, 1);
        System.out.println(user==user1);
        logger.info( "1user============="+user);
        logger.debug("2user============="+user);
        logger.error("3user============="+user);
        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        User user2 = session2.get(User.class, 1);
        System.out.println(user1==user2);
        session2.getTransaction().commit();
        session2.close();
    }
}
