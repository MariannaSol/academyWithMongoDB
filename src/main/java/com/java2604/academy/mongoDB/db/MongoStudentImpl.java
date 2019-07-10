package com.java2604.academy.mongoDB.db;

import com.java2604.academy.mongoDB.Entities.Person;
import com.java2604.academy.mongoDB.Entities.Student;
import com.java2604.academy.mongoDB.MongoUtils.MongoConnector;
import com.mongodb.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MongoStudentImpl implements StudentDAO{
    private MongoConnector mongoConnector;
    private DBCollection table;

    public MongoStudentImpl(MongoConnector mongoConnector) {
        this.mongoConnector = mongoConnector;
    }

    @Override
    public void save(Student student) {
        BasicDBObject document = new BasicDBObject();
        Map studentMap = new HashMap();
        Map map = new HashMap();

        map.put("id", student.getPerson().getId());
        map.put("name", student.getPerson().getName());
        map.put("login", student.getPerson().getLogin());
        map.put("birthday", new Date());
        map.put("passport", student.getPerson().getPassport());
        map.put("phone", student.getPerson().getPhone());
        studentMap.put("person", map);
        studentMap.put("startDate", student.getStart());

        document.putAll(studentMap);

        try {
            table = mongoConnector.getDb().getCollection("Student");
            table.insert(document);
            System.out.println("Insert student");
        }
        catch (MongoCommandException mce)
        {
            table = mongoConnector.getDb().createCollection("Student", document);
        }

    }

    @Override
    public Student find(Student login) {
//        BasicDBObject document = new BasicDBObject();
//        Map map = new HashMap();
//        map.put("login", login.getPerson().getLogin());
//        System.out.println(map.toString());
//        document.put("person", map);
//
//        table = mongoConnector.getDb().getCollection("Student");
//        DBObject result = table.findOne(document);
//        Student student = new Student();
//        System.out.println(result.toString());
//        student.setPerson((Person) result.get("person"));
//        student.setStart((Date) result.get("startDate"));

        return null;
    }

    @Override
    public void delete(String id) {
//        BasicDBObject document = new BasicDBObject();
//        document.put("_id", id);
//        table.remove(document);
    }
}
