package com.hibernate.one_one.entity;

public class Wife {
    private Integer id;
    private String name;
    private HusBand husBand;

    public HusBand getHusBand() {
        return husBand;
    }

    public void setHusBand(HusBand husBand) {
        this.husBand = husBand;
    }

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
}
