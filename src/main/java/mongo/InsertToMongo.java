package mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.SelectFormTable;

import java.util.Map;
import java.util.function.Consumer;

public class InsertToMongo<T> {

    static void getPostgresToMongo(MongoClient mongoClient) {
        /**>>>>>>>>> вставка <<<<<<<<<<<<*/
//        var mongoClient = MongoClients.create();
        mongoClient.listDatabases();
        mongoClient.listDatabaseNames()
                .forEach((Consumer<String>) System.out::println);

        var database = mongoClient.getDatabase("syn");

//            MongoCollection<Document> todoCollection = database.getCollection("todo");
//            todoCollection = database.getCollection("todo");

        MongoCollection<Document> fromPostgresColection = database.getCollection("fromPostgres");
        fromPostgresColection = database.getCollection("fromPostgres");


//            var todoDocment = new Document(Map.of(
//                    "_id", new ObjectId(),
//                    "task", "Drynk some coffee",
//                    "dataCreated", LocalDateTime.now(),
//                    "done", false));

        var fromPostgresDocument = new Document((Map<String, ?>) SelectFormTable.get_All_to_JSONArray());

        fromPostgresColection.insertOne((Document) fromPostgresDocument);


//            database.listCollectionNames()
//                    .forEach((Consumer<String>) System.out::println);
        database.listCollections()
                .forEach((Consumer<Document>) System.out::println);
    }
}
