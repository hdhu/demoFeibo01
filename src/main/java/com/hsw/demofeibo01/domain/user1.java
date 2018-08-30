package com.hsw.demofeibo01.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class user1 implements Serializable {
    @Id
    @GeneratedValue
    private  Integer id;
    private  String pwd;
    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
