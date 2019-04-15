package com.hibernate.dao;

import com.hibernate.entity.Student;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/12;
 */
public interface StudentDao {
    public int add(Student s);

    public int update(Student s);

    public int delete(Student s);

    public Student queryOne(Integer id);
    //pageIndex页码 pageCount每页条数
    public List<Student> queryPage(int pageIndex,int pageCount);
    //得到总页数
    public int pages(int pageCount);


}
