package com.hibernate.dao;


import com.hibernate.entity.P;
import com.hibernate.entity.R;
import com.hibernate.entity.U;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {

    Session session=null;
    @Before
    public void before(){
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @After
    public void after(){
        session.getTransaction().commit();
        session.close();
    }

    //添加用户和角色
    @Test
    public void addUAndR(){
        //3个用户
        U u1 = new U("aaa111");
        U u2 = new U("bbb222");
        U u3 = new U("ccc333");
        //2个角色
        R r1 = new R();
        r1.setR_name("新闻管理员");
        R r2 = new R();
        r2.setR_name("文档管理员");
        //用户1添加2个角色
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        //用户2添加2个角色
        u2.getRoles().add(r1);
        u2.getRoles().add(r2);
        //用户3添加1个角色
        u3.getRoles().add(r1);
        //添加3个用户
        session.save(u1);
        session.save(u2);
        session.save(u3);
    }

    //删除用户的角色
    @Test
    public void deleteUR(){
        //查询到用户1
        U user = session.get(U.class, 1);
        //查询到角色1
        R role = session.get(R.class, 1);
        //删除remove用户1的角色1
        user.getRoles().remove(role);
    }
    //添加用户的角色
    @Test
    public void addUR(){
        //查询到用户1
        U user = session.get(U.class, 1);
        //查询到角色1
        R role = session.get(R.class, 1);
        //添加remove用户1的角色1
        user.getRoles().add(role);
    }

    //添加角色和权限
    @Test
    public void addRAndP(){
        R role1=new R("财务主管");
        R role2=new R("行政主管");
        R role3=new R("总经理");
        P permissions1=new P("财务管理");
        P permissions2=new P("行政管理");
        role1.getPermissionss().add(permissions1);
        role2.getPermissionss().add(permissions2);
        role3.getPermissionss().add(permissions1);
        role3.getPermissionss().add(permissions2);
        session.save(role1);
        session.save(role2);
        session.save(role3);
    }
    //删除角色的权限
    @Test
    public void deleteRP(){
        //查询到角色7
        R role = session.get(R.class, 7);
        //查询到权限1
        P permissions=session.get(P.class,1);
        //删除remove角色7的权限1
        role.getPermissionss().remove(permissions);
    }
    //添加角色的权限
    @Test
    public void addRP(){
        //查询到角色7
        R role = session.get(R.class, 7);
        //查询到权限1
        P permissions=session.get(P.class,1);
        //删除remove角色7的权限1
        role.getPermissionss().add(permissions);
    }
}
