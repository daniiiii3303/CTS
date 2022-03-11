package ro.ase.acs.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import ro.ase.acs.contracts.nosqlable.NoSqlMethods;

public class CreateTable implements NoSqlMethods {
    @Override
    public MongoDatabase nosqlMethod() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");

        return mongoDb;
    }
}
