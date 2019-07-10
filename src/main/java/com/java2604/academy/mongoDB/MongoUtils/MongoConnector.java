package com.java2604.academy.mongoDB.MongoUtils;

import com.mongodb.*;


public class MongoConnector implements AutoCloseable {
    private MongoClient mongoClient;

    private DB db;

    public MongoConnector(MongoClient mongoClient, DB db) {
        this.mongoClient = mongoClient;
        this.db = db;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void close() throws Exception {
        mongoClient.close();
    }

}
