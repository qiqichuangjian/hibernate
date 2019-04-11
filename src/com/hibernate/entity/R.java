package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
@Entity
@Table(name = "r")
public class R{
    private Integer r_id;
    private String r_name;
    private Set<U> users= new HashSet<>();
    private Set<P> permissionss= new HashSet<>();
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name="r_id")
    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }
    @Column(name="r_name")
    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }
    @ManyToMany(mappedBy = "roles")
    public Set<U> getUsers() {
        return users;
    }

    public void setUsers(Set<U> users) {
        this.users = users;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "r_p",
            joinColumns ={@JoinColumn(name="r_id")},
            inverseJoinColumns = {@JoinColumn(name="p_id")}
    )
    public Set<P> getPermissionss() {
        return permissionss;
    }

    public void setPermissionss(Set<P> permissionss) {
        this.permissionss = permissionss;
    }

    public R(String r_name) {
        this.r_name = r_name;
    }
    public R() {
    }

}
