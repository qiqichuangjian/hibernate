package com.hibernate.entity;

/**
 * @Acthor:孙琪; date:2019/4/9;
 */
public class Department {
    private Integer id;
    private String name;
//    private Set<Department> departmentSet= new HashSet<>();

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

//    public Set<Department> getDepartmentSet() {
//        return departmentSet;
//    }
//
//    public void setDepartmentSet(Set<Department> departmentSet) {
//        this.departmentSet = departmentSet;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
