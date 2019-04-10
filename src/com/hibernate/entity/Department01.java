package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Acthor:孙琪; date:2019/4/9;
 */
@Entity
@Table(name = "department01")
public class Department01 {
    private Integer did;
    private String dname;

    @Id
    @GenericGenerator(name = "native",strategy = "native")
    @GeneratedValue(generator = "native")
    @Column(name = "d_id")
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
    @Column(name = "d_name")
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department01{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }


    public Department01() {
    }

    public Department01(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }
}
