package com.ssm.entity;

import java.util.Date;

public class User {
    private double id;
    private String name;
    private String gender;
    private Date born;
    private String position;
    private double salary;
    private String bornStr;

    public double getId() {
        return id;
    }

//    public void setId(double id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBornStr() {
        return bornStr;
    }

    public void setBornStr(String bornStr) {
        this.bornStr = bornStr;
    }
}
