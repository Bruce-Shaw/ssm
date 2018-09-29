package com.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;
    private String uid;
    private String psw;
    private Integer level;
    private String name;
    private Integer gender;
    private Date born;
    private String position;
    private Long salary;
    private String bornStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUid(String uid) { this.uid = uid; }

    public String getUid() {
        return uid;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getBornStr() {
        return bornStr;
    }

    public void setBornStr(String bornStr) {
        this.bornStr = bornStr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid=" + uid +
                ", psw='" + psw + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", born=" + born +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", bornStr='" + bornStr + '\'' +
                '}';
    }
}
