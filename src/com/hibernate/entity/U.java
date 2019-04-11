package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
@Entity
@Table(name = "u")
public class U {
    private Integer u_id;
    private String u_name;
    private Set<R> roles = new HashSet<>();

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name="u_id")
    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }
    @Column(name="u_name")
    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "u_r",
            joinColumns ={@JoinColumn(name="u_id")},
            inverseJoinColumns = {@JoinColumn(name="r_id")}
    )
    public Set<R> getRoles() {
        return roles;
    }

    public void setRoles(Set<R> roles) {
        this.roles = roles;
    }

    public U(String u_name) {
        this.u_name = u_name;
    }

    public U() {
    }
}
