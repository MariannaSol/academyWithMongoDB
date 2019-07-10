package com.java2604.academy.mongoDB.maps;

import com.java2604.academy.mongoDB.Entities.Person;
import com.mongodb.DBObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PersonMap {
    private Person person;

    public PersonMap(Person person) {
        this.person = person;
    }

    public PersonMap() {
    }

    public Map parse() {
        Map personMap = new HashMap();
        personMap.put("name", person.getName());
        personMap.put("login", person.getLogin());
        personMap.put("birthday", new Date());
        personMap.put("passport", person.getPassport());
        personMap.put("phone", person.getPhone());

        return personMap;
    }

    public Person buildPerson(DBObject result) {
        Person newPerson = new Person();
        newPerson.setId(String.valueOf(result.get("_id")));
        newPerson.setLogin(String.valueOf(result.get("login")));
        newPerson.setName(String.valueOf(result.get("name")));
        newPerson.setBirthday((Date) result.get("birthday"));
        newPerson.setPassport(String.valueOf(result.get("passport")));
        newPerson.setPhone(String.valueOf(result.get("phone")));

        return newPerson;
    }
}
