package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Integer u_id;
    private String u_name;
    private Set<Role> roleSet = new HashSet<>();

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public User() {
    }

    public User(Integer u_id, String u_name, Set<Role> roleSet) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.roleSet = roleSet;
    }
    public User(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
