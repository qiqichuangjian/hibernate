package com.hibernate.dao;

import com.hibernate.entity.Permissions;
import com.hibernate.entity.Role;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class URPJunitTest {

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
    public void addUserAndRole(){
        //3个用户
        User user1 = new User("aaa111");
        User user2 = new User("bbb222");
        User user3 = new User("ccc333");
        //2个角色
        Role role1 = new Role();
        role1.setR_name("新闻管理员");
        Role role2 = new Role();
        role2.setR_name("文档管理员");
        //用户1添加2个角色
        user1.getRoleSet().add(role1);
        user1.getRoleSet().add(role2);
        //用户2添加2个角色
        user2.getRoleSet().add(role1);
        user2.getRoleSet().add(role2);
        //用户3添加1个角色
        user3.getRoleSet().add(role1);
        //添加3个用户
        session.save(user1);
        session.save(user2);
        session.save(user3);
    }

    //删除用户的角色
    @Test
    public void deleteUserRole(){
        //查询到用户1
        User user = session.get(User.class, 1);
        //查询到角色1
        Role role = session.get(Role.class, 1);
        //删除remove用户1的角色1
        user.getRoleSet().remove(role);
    }
    //添加用户的角色
    @Test
    public void addUserRole(){
        //查询到用户1
        User user = session.get(User.class, 1);
        //查询到角色1
        Role role = session.get(Role.class, 1);
        //添加remove用户1的角色1
        user.getRoleSet().add(role);
    }

    //添加角色和权限
    @Test
    public void addRoleAndPermissions(){
        Role role1=new Role("财务主管");
        Role role2=new Role("行政主管");
        Role role3=new Role("总经理");
        Permissions permissions1=new Permissions("财务管理");
        Permissions permissions2=new Permissions("行政管理");
        role1.getPermissionsSet().add(permissions1);
        role2.getPermissionsSet().add(permissions2);
        role3.getPermissionsSet().add(permissions1);
        role3.getPermissionsSet().add(permissions2);
        session.save(role1);
        session.save(role2);
        session.save(role3);
    }
    //删除角色的权限
    @Test
    public void deleteRolePermissions(){
        //查询到角色7
        Role role = session.get(Role.class, 7);
        //查询到权限1
        Permissions permissions=session.get(Permissions.class,1);
        //删除remove角色7的权限1
        role.getPermissionsSet().remove(permissions);
    }
    //添加角色的权限
    @Test
    public void addRolePermissions(){
        //查询到角色7
        Role role = session.get(Role.class, 7);
        //查询到权限1
        Permissions permissions=session.get(Permissions.class,1);
        //删除remove角色7的权限1
        role.getPermissionsSet().add(permissions);
    }

}
