package com.java2604.academy.mongoDB.Entities;

import java.util.Date;
import java.util.Set;

public class Person {

    private String id;

    private String login;

    private String name;

    private Date birthday;

    private String passport;

    private String phone;

    private Set<Student> studentSet;
//
//    private Set<Teacher> teacherSet;


    public Person(String login, String name, Date birthday, String passport, String phone) {
        this.login = login;
        this.name = name;
        this.birthday = birthday;
        this.passport = passport;
        this.phone = phone;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", passport='" + passport + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
