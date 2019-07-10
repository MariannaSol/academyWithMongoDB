package com.java2604.academy.mongoDB.Entities;

import java.util.Date;

public class Student {

    private long id;

    private Date start;

    private Date finish;

    private String diploma;

    private Person person;

    public Student(Person person, Date start) {
        this.person = person;
        this.start = start;
    }

    public Student() {
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", start=" + start +
                ", finish=" + finish +
                ", diploma='" + diploma + '\'' +
                ", person=" + person +
                '}';
    }
}
