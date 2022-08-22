package com.theloneguy.plugins.noregisterauth.DataBase;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.theloneguy.plugins.noregisterauth.ConfigGetters;
import org.bson.Document;

public class Mongo {
    public static MongoCollection<Document> collection;
    String conn_uri = ConfigGetters.getconfig("mongourl");

    public void connect() {
        MongoClient monclient = MongoClients.create(conn_uri);
        collection = monclient.getDatabase(ConfigGetters.getconfig("mongodatabase")).getCollection(ConfigGetters.getconfig("mongocollection"));
    }

}
