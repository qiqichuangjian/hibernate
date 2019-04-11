package com.hibernate.dao;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
public class JT {
    Session session = null;

    @Before
    public void before() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @After
    public void after() {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void addUser() {

        for (int i = 0; i < 10; i++) {
            User user = new User("admin" + i);
            session.save(user);
        }
    }

    /**
     * 查询全部
     */
    @Test
    public void queryAll() {
        String hql = "from User";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 通过id查询   查第一个
     */
    @Test
    public void queryOne() {
        String hql = "from User where u_id = :uid ";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("uid", 1);
        User user = query.list().get(0);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void queryLike() {
        // :后面是别名  <id5的所有  即id1-id4
        String hql = "from User where u_id < :uid ";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("uid", 5);
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void queryPage() {
        // hql语句
        String hql = "from User ";
        // 创建查询
        Query<User> query = session.createQuery(hql, User.class);
        // 查询开始索引
        query.setFirstResult(3);
        // 每页显示条数
        query.setMaxResults(5);   //显示admin3-7这5条数据
        // 获取查询信息
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 命名查询
     */
    @Test
    public void queryLike2() {
        // xml映射的hql语句名  写在xml中，为了引入hql语句
        String name = "queryUser";
        // 创建名称查询
        Query<User> query = session.getNamedQuery(name);
        //名称模糊查询
        query.setParameter("u_name", "a%");
        // 获取查询信息
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 投影查询
     */
    @Test
    public void queryTouYing() {
        //hql语句
        String hql = "select u_id,u_name from User";
        // 创建查询   Object[],Arrays 数组
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        // 获取查询信息
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
            //获取数组的第1列，即id
            System.out.println(objects[0]);
        }
    }

    /**
     * 聚合查询
     */
    @Test
    public void queryCount() {
        //hql语句   查询User里有几条数据
        String hql = "select count(*) from User";
        // 创建名称查询
        Query<Object> query = session.createQuery(hql, Object.class);
        // 获取查询信息  当确定返回的实例只有一个或者null时 用uniqueResult()方法
        Object objects = query.uniqueResult();
        //强转objects为Number型
        Number num = (Number) objects;
        //intValue()是java.lang.Number类的方法，意为输出int数据
        int i = num.intValue();
        System.out.println("i=" + i);
    }

    @Test
    public void queryCount1() {
        //hql语句   count(1)，count(2)，count(*)，第几列都有相同条数据
        String hql = "select count(1) from User";
        // 创建名称查询
        Query<Object> query = session.createQuery(hql, Object.class);
        // 获取查询信息
        Object objects = query.uniqueResult();
        System.out.println(objects);
    }

    //OID对象映射标识符
    //为了在系统中能够找到所需对象，我们需要为每一个对象分配一个唯一的表示号。
    //在关系数据库中我们称之为关键字，而在对象术语中，则叫做对象标识(Object identifier-OID).
    @Test
    public void queryOID() {
/*都是查询
1. session.load()
这种方式总是会返回一个代理而不是真正得去查询数据库。 在Hibernate里面，代理是一个依据ID值获取到的对象，该对象的属性还没有初始化，它看起来就是一个临时的虚拟对象而已。
如果load方法没有找到数据，就会抛出ObjectNotFoundException.
2. session.get()
这种方式总是会去数据库查询数据并返回一个真实的对象，该对象就代表数据库中的一行而非代理。
如果没有找到数据就会返回null.*/
        User user2 = session.load(User.class, 2);
        User user1 = session.get(User.class, 1);
        System.out.println(user2);
        System.out.println(user1);
    }


}

