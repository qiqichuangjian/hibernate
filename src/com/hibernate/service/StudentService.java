package com.hibernate.service;

import com.hibernate.dao.StudentDao;
import com.hibernate.dao.daoImpl.StudentDaoImpl;
import com.hibernate.entity.Student;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/12;
 */
public class StudentService {
    StudentDao dao=new StudentDaoImpl();
    public int add(Student s){
        return dao.add(s);
    }

    public int update(Student s){
        return dao.update(s);}

    public int delete(Student s){
        return dao.delete(s);}

    public Student queryOne(Integer id){
        return dao.queryOne(id);}
    //pageIndex页码 pageCount每页条数
    public List<Student> queryPage(int pageIndex, int pageCount){
        return dao.queryPage(pageIndex,pageCount);}
    //得到总页数
    public int pages(int pageCount){
        return dao.pages(pageCount);}
}
