package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
@Entity
@Table(name = "p")
public class P {
    private Integer p_id;
    private String p_name;
    private Set<R> roles= new HashSet<>();
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name="p_id")
    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }
    @Column(name="p_name")
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    @ManyToMany(mappedBy = "permissionss")
    public Set<R> getRoles() {
        return roles;
    }

    public void setRoles(Set<R> roles) {
        this.roles = roles;
    }

    public P(String p_name) {
        this.p_name = p_name;
    }
}
