package com.hibernate.one_one.dao;

import com.hibernate.one_one.entity.HusBand;
import com.hibernate.one_one.entity.Wife;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Acthor:孙琪; date:2019/4/10;
 */
public class CPDao {
    Session session=null;
    @Before
    public void before(){
        session= HibernateUtil.getSession();
        session.beginTransaction();
    }
    @After
    public void after(){
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void addHusBand(){
        Wife wife1 = new Wife();
        wife1.setName("老婆1");
        HusBand husBand1  = new HusBand();
        husBand1.setName("老公1");
        //夫妻互相绑定
        husBand1.setWife(wife1);
        wife1.setHusBand(husBand1);
        session.save(husBand1);
        //husband主键共享
        Wife wife2 = new Wife();
        wife2.setName("老婆2");
        HusBand husBand2  = new HusBand();
        husBand2.setName("老公2");
        husBand2.setWife(wife2);
        wife1.setHusBand(husBand2);
        session.save(husBand2);

    }
}
