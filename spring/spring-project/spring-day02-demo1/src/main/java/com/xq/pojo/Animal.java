package com.xq.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Animal {

    @Value("1001") //给基本数据类型或者String类型赋值
    private int id;

    @Value("小黑")
    private String name;

    @Value("black")
    private String color;

    @Value("2")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct //将该方法设置为初始化方法 随着ApplicationContext的创建而执行
    public void init(){
        System.out.println("初始化方法被调用");
    }

    @PreDestroy //将该方法设置为销毁方法 随着ApplicationContext的关闭而执行
    public void destroy(){
        System.out.println("销毁方法被调用");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
