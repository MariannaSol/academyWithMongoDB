package com.java2604.academy.mongoDB.db;

import com.java2604.academy.mongoDB.Entities.Person;

public interface PersonDAO {
    void save(Person person);
    Person find(String login);
    void delete(String login);
}
