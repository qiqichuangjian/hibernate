package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
public class Permissions {
    private Integer p_id;
    private String p_name;
    private Set<Role> roleSet= new HashSet<>();

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public Permissions() {
    }

    public Permissions(Integer p_id, String p_name, Set<Role> roleSet) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.roleSet = roleSet;
    }
    public Permissions(String p_name) {
        this.p_name = p_name;
    }
}
