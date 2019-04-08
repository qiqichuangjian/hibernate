package com.hibernate.entity;

import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/4/8;
 */

public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Date borthday;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorthday() {
        return borthday;
    }

    public void setBorthday(Date borthday) {
        this.borthday = borthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", borthday=" + borthday +
                '}';
    }
}
