package com.yuna.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100,name="name")
    private String name;

    //@Column(name="department_id")//学生宿舍外键
    //private Integer departmentId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="departmentId")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student() {
        super();
    }

}
