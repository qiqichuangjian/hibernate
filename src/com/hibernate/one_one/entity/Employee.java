package com.hibernate.one_one.entity;

public class Employee {
    private int id;
    private String name;
    private JoinPart joinPart;//党组织

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JoinPart getJoinPart() {
        return joinPart;
    }

    public void setJoinPart(JoinPart joinPart) {
        this.joinPart = joinPart;
    }
}
