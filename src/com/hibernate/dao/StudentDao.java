package com.hibernate.dao;

import com.hibernate.entity.Classes;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class StudentDao {
    Session session = null;

    @Before
    public void before() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    @After
    public void after() {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void add() throws ParseException {
        for (int i = 0; i < 10000; i++) {
            Student student = new Student();
            student.setName("zhangfei");
            student.setSex("男");
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-11-11"));
            session.save(student);
            if (i % 1000 == 0) {
                session.flush();
                session.clear();
            }
        }
    }

    @Test
    public void update() {
        Student student = session.get(Student.class, 1);
        //修改哪条弄哪条，其余不用写
        student.setName("zhangsan");
        student.setSex("女");
        session.save(student);
    }

    @Test
    public void delete() {
        Student student = session.get(Student.class, 1);
        session.delete(student);
    }

    @Test
    public void query() {
        //---------查询全部
        // 查询的是对象（类名）
        String hql = "from Student";
        Query query = session.createQuery(hql);
        List<Student> list = query.list();
        //遍历需要toString才不会遍历出地址
        for (Student s : list) {
            System.out.println(s);
        }
        //----------查询某条
        System.out.println("-------------");
        Student s = session.get(Student.class, 4);
        System.out.println(s);
    }

    @Test
    public void query01() {
        //有几个值就查询几次
        Student s1 = session.get(Student.class, Integer.valueOf(2));
        Student s2 = session.get(Student.class, Integer.valueOf(3));
        Student s3 = session.get(Student.class, Integer.valueOf(2));
        Student s4 = session.get(Student.class, 2);
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true
        System.out.println(s3 == s4);//true
    }

    @Test
    public void add01() {
        //得到session对象
        session = HibernateUtil.getSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        Student student1 = new Student(); //  临时对象
        student1.setName("小明1");
        Student student2 = new Student(); //  临时对象
        student2.setName("小明2");
        session.save(student1); // 持久化对象
        session.save(student2); // 持久化对象
        session.delete(student2); //删除对象
        Student stu2 = session.get(Student.class, 2); // 删除对象
        System.out.println(stu2);
        //提交
        transaction.commit();
        Student stu = session.get(Student.class, 1); // 游离对象
        System.out.println(stu);
        //关闭
        session.close();
    }
    @Test
    public void addStudentAndClass(){
        //先有班级才有学生
        Classes classes = new Classes();
        classes.setName("java班");
        session.save(classes);
        Student s1 =  new Student();
        s1.setName("张三");
        s1.setClasses(classes);
        Student s2 =  new Student();
        s2.setName("李四");
        s2.setClasses(classes);
        session.save(s1);
        session.save(s2);
    }
    @Test
    public void addStudentAndClass2(){
        Classes classes = new Classes();
        classes.setName("java2班");
        //session.save(classes);
        Student s1 =  new Student();
        s1.setName("王五");
        s1.setClasses(classes);
        Student s2 =  new Student();
        s2.setName("赵六");
        s2.setClasses(classes);
        session.save(s1);
        session.save(s2);
    }
    //通过学生查找班级
    @Test
    public void queryClasses() {
        Student s = session.get(Student.class, 2);
        System.out.println(s.getClasses().getName());
    }
    @Test
    public void queryStudent(){
        Student s = session.get(Student.class, 2);
        System.out.println(s);
    }
}
