package com.java2604.academy.mongoDB.db;

import com.java2604.academy.mongoDB.Entities.Person;
import com.java2604.academy.mongoDB.MongoUtils.MongoConnector;
import com.java2604.academy.mongoDB.maps.PersonMap;
import com.mongodb.*;

public class MongoPersonImpl implements PersonDAO {
    private MongoConnector mongoConnector;
    private DBCollection table;

    public MongoPersonImpl(MongoConnector mongoConnector) {
        this.mongoConnector = mongoConnector;
    }

    @Override
    public void save(Person person) {
        BasicDBObject document = new BasicDBObject();

        PersonMap personMap = new PersonMap(person);

        document.putAll(personMap.parse());

        try {
            table = mongoConnector.getDb().getCollection("Person");
            table.insert(document);
            System.out.println("Insert person " + person.getName());
        }
        catch (MongoCommandException mce)
        {
            table = mongoConnector.getDb().createCollection("Person", document);
        }
    }

    @Override
    public Person find (String login) {
        BasicDBObject document = new BasicDBObject();
        document.put("login", login);

        table = mongoConnector.getDb().getCollection("Person");
        DBObject result = table.findOne(document);
        PersonMap personMap = new PersonMap();

        return personMap.buildPerson(result);
    }

    @Override
    public void delete(String login) {
        BasicDBObject document = new BasicDBObject();
        document.put("login", login);
        table.remove(document);
    }
}
