package com.hibernate.service;

import com.hibernate.dao.UserDao;
import com.hibernate.dao.UserDaoImpl;
import com.hibernate.entity.User;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
public class UserService {
    UserDao dao=new UserDaoImpl();
    public int add(User user){
        return dao.add(user);
    }
    public int update(User user){
        return dao.update(user);
    }
    public int delete(User user){
        return dao.delete(user);
    }
    public List<User> findAll(){
        return dao.findAll();
    }
    public User findUserById(Integer id){
        return dao.findUserById(id);
    }
}
