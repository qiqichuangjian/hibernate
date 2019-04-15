package com.hibernate.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Acthor:孙琪; date:2019/4/12;
 */
@Entity
@Table(name = "s")
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    @Id
    @GeneratedValue(generator = "_mm")
    @GenericGenerator(name = "_mm",strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student() {
    }
}
