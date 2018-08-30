package com.hsw.demofeibo01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class user implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty(message = "昵称不能为空")
    private String nickname;  //中文名
    @NotEmpty(message = "用户名不能为空")
    private String username;  //用户名
    //    @Size(  min=6,max=10,message = "密码长度必须6到10位")
    private String password;
    //    @Size(  min=6,max=10,message = "密码长度必须6到10位")
//    private String passward;
    @Size(  min=11,max=11,message = "手机号不对")
    private String cellphone;
    private Integer gender; //1:男 2：女
    @Email
    private String email;
    private String qq;
    private String first_name ;  //英文名 仅展示
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", first_name='" + first_name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
