package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/4/8;
 */
@Entity
@Table(name = "teacher01")
public class Teacher01 {
    private Integer tId;
    private String tName;
    private Integer tAge;
    private String tSex;
    private Date tBorthday;
    @Id
    @GenericGenerator(name = "_native",strategy = "native")
    @GeneratedValue(generator = "native")
    @Column(name = "t_id")
    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }
    @Column(name = "t_name")
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
    @Column(name = "t_age")
    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }
    @Column(name = "t_sex")
    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }
    @Column(name = "t_borthday")
    public Date gettBorthday() {
        return tBorthday;
    }

    public void settBorthday(Date tBorthday) {
        this.tBorthday = tBorthday;
    }

    @Override
    public String toString() {
        return "Teacher01{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tAge=" + tAge +
                ", tSex='" + tSex + '\'' +
                ", tBorthday=" + tBorthday +
                '}';
    }
}



