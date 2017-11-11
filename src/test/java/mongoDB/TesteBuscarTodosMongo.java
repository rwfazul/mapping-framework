/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class TesteBuscarTodos {
    
    public static void main(String[] args) {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("registros");
        MongoCollection<Document> collection = database.getCollection("pessoas");
        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }
    }
   
}
