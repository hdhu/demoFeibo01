package com.hsw.demofeibo01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class stu {
    @Id
    @GeneratedValue
    private Integer id;

    private String clazz;
    @Min(value = 5,message = "too young!")
    private Integer age;

    public stu() {
    }

    public stu(String clazz, @Min(value = 5, message = "too young!") Integer age) {
        this.clazz = clazz;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "stu{" +
                "id=" + id +
                ", clazz='" + clazz + '\'' +
                ", age=" + age +
                '}';
    }
}
