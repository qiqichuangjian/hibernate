package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {

    private Integer r_id;
    private String r_name;
    private Set<User> userSet= new HashSet<>();
    private Set<Permissions> permissionsSet= new HashSet<>();

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<Permissions> getPermissionsSet() {
        return permissionsSet;
    }

    public void setPermissionsSet(Set<Permissions> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    public Role() {
    }

    public Role(Integer r_id, String r_name, Set<User> userSet, Set<Permissions> permissionsSet) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.userSet = userSet;
        this.permissionsSet = permissionsSet;
    }
    public Role(String r_name) {
        this.r_name = r_name;
    }
}
