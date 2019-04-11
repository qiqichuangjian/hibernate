package com.hibernate.one_one.dao;

import com.hibernate.one_one.entity.Employee;
import com.hibernate.one_one.entity.JoinPart;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpDao {
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
    public void addEmployee(){
        JoinPart joinPart1 =  new JoinPart();
        joinPart1.setPname("共产党员");
        Employee employee1 = new Employee();
        employee1.setName("刘胡兰");
        //互相绑定
        employee1.setJoinPart(joinPart1);
        joinPart1.setEmployee(employee1);
        //互相保存
        session.save(employee1);
        session.save(joinPart1);

        JoinPart joinPart2 =  new JoinPart();
        joinPart2.setPname("共青团员");
        Employee employee2 = new Employee();
        employee2.setName("孙琪");
        //互相绑定
        employee2.setJoinPart(joinPart2);
        joinPart2.setEmployee(employee2);
        //互相保存
        session.save(employee2);
        session.save(joinPart2);
    }
    @Test
    //删除关联关系  使员工失去组织，其余不变
    public void delete(){
        Employee em = session.get(Employee.class, 1);
        em.setJoinPart(null);
        JoinPart jp = session.get(JoinPart.class, 1);
        session.update(em);
        session.delete(jp);
    }

}
