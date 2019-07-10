package com.java2604.academy.mongoDB.db;

import com.java2604.academy.mongoDB.Entities.Person;
import com.java2604.academy.mongoDB.Entities.Student;

public interface StudentDAO {
    void save(Student student);
    Student find(Student login);
    void delete(String login);
}
