package com.hibernate.dao;

import com.hibernate.entity.Classes;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @Acthor:孙琪; date:2019/4/10;
 */
public class ClassesDao {
    Session session=null;
    @Before
    public void before(){
        session= HibernateUtil.getSession();
        session.beginTransaction();
    }
    @After
    public void after(){
        session.getTransaction().commit();;
        session.close();
    }
    //一对多映射
    @Test
    public  void addClassAndStudent(){
        Classes classes =  new Classes();
        classes.setName("UI02");

        Student s1= new Student();
        s1.setName("小红");
        s1.setClasses(classes);
        Student s2= new Student();
        s2.setName("小绿");
        s2.setClasses(classes);
         //班级添加学生
        classes.getStudentSet().add(s1);
        classes.getStudentSet().add(s2);
        //session.save(classes);
        session.save(s1);
        session.save(s2);
    }
    //通过班级查找学生
    @Test
    public  void queryStudentByClass(){
        Classes classes = session.get(Classes.class, 1);
        //学生多个，需要遍历
        Set<Student> studentSet = classes.getStudentSet();
        for (Student s:studentSet) {
            System.out.println(s);
        }
    }
    //非关联修改：修改第1个班级信息，并修改第1个班级下全部学生的某一属性。
    @Test
    public  void update(){
        Classes classes = session.get(Classes.class, 1);
        classes.setName("java01");
        Set<Student> studentSet = classes.getStudentSet();
        for (Student s:studentSet) {
           // s.setName("小小");
            s.setSex("女");
        }
    }
    // 设定学生1不属于任何班级，删除学生1的班级信息
    @Test
    public  void delete(){
        Student student = session.get(Student.class, 1);
        student.setClasses(null);
        session.save(student);
    }

    // 给学生1添加班级1
    @Test
    public  void addClassToStudnet(){
        Student student = session.get(Student.class, 1);
        Classes classes =session.get(Classes.class, 1);
        student.setClasses(classes);
        classes.getStudentSet().add(student);
    }

    // 删除班级1及班级1里的学生，通过一对多的映射完成
    @Test
    public  void deleteClasses(){
        Classes classes =session.get(Classes.class, 1);
        session.delete(classes);
    }


}
