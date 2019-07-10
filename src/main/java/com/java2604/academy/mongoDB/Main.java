package com.java2604.academy.mongoDB;

import com.java2604.academy.mongoDB.Entities.Person;
import com.java2604.academy.mongoDB.Entities.Student;
import com.java2604.academy.mongoDB.MongoUtils.MongoConnector;
import com.java2604.academy.mongoDB.db.*;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = new DB(mongoClient, "academy");

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("login1","Vasya", new Date(), "RR679087", "80976789876"));
        persons.add(new Person("login2","Petya", new Date(), "TT678909", "80976789878"));
        persons.add(new Person("login3","Kate", new Date(), "RR679090", "80976789879"));
        persons.add(new Person("login4","John", new Date(), "RR679091", "80976789880"));
        persons.add(new Person("login5","Alisa", new Date(), "RR679092", "80976789881"));
        persons.add(new Person("login6","Alisa", new Date(), "RR679093", "80976789882"));

       try(MongoConnector mongoConnector = new MongoConnector(mongoClient, db)) {
           PersonDAO personDAO = new MongoPersonImpl(mongoConnector);
           for(Person person: persons) {
               personDAO.save(person);
           }
           System.out.println("Find person" + personDAO.find("login6"));

           personDAO.delete("login5");
            try {
               personDAO.find("login5");
            }
            catch (NullPointerException npe) {
                System.out.println("Delete person");
            }

           StudentDAO studentDAO = new MongoStudentImpl(mongoConnector);
           studentDAO.save(new Student(personDAO.find("login4"), new Date()));

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
