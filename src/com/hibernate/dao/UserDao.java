package com.hibernate.dao;

import com.hibernate.entity.User;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
public interface UserDao {
    public int add(User user);
    public int update(User user);
    public int delete(User user);
    public List<User> findAll();
    public User findUserById(Integer id);
    public List<User> queryPageUser(int pageIndex,int pageCount);
    public int pages(int pageCount);

}
