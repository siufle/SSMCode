package com.xq.pojo;

public class Emp {

    private Integer id;

    private String name;

    private Integer age;

    private Department department;

    public Emp() {
    }

    public Emp(Integer id, String name, Integer age, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
