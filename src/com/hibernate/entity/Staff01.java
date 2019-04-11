package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Acthor:孙琪; date:2019/4/9;
 */
@Entity
@Table(name = "staff01")
public class Staff01 {
    private Integer sid;
    private String sname;
    private Department01 department01;//部门

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "s01_id")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Column(name = "s_name")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @ManyToOne
   //@ManyToOne就行了，完成了单向绑定
    @JoinColumn(name = "d_id")
    public Department01 getDepartment01() {
        return department01;
    }

    public void setDepartment01(Department01 department01) {
        this.department01 = department01;
    }

    @Override
    public String toString() {
        return "Staff01{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", department01=" + department01 +
                '}';
    }

}
