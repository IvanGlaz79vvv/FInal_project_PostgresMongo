package mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.SelectFormTable;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import static org.example.SelectFormTable.get_All_to_JSONArray;

public class InsertToMongo<T> {
    public static void main(String[] args) {

        try (var mongoClient = MongoClients.create()) {
//        mongoClient.listDatabases();
//        mongoClient.listDatabaseNames()
//                .forEach((Consumer<String>) System.out::println);

            var database = mongoClient.getDatabase("syn");
            database.createCollection("fromPostgres");

            MongoCollection<Document> fromPostgresColection = database.getCollection("fromPostgres");

            Map <String, String> map = new HashMap<>();
            var fromPostgresDocument = new Document(Map.of(
                    "1", SelectFormTable.get_All_to_JSONArray().get(1).toString(),
                    "2", SelectFormTable.get_All_to_JSONArray().get(2).toString(),
                    "3", SelectFormTable.get_All_to_JSONArray().get(3).toString(),
                    "4", SelectFormTable.get_All_to_JSONArray().get(4).toString(),
                    "5", SelectFormTable.get_All_to_JSONArray().get(5).toString(),
                    "6", SelectFormTable.get_All_to_JSONArray().get(6).toString()
//                    "7", SelectFormTable.get_All_to_JSONArray().get(7).toString()
//                    "8", SelectFormTable.get_All_to_JSONArray().get(8).toString()
//                    "9", SelectFormTable.get_All_to_JSONArray().get(9).toString()
                    ));
            fromPostgresColection.insertOne(fromPostgresDocument);


//        database.listCollectionNames()
//                .forEach((Consumer<String>) System.out::println);
//        database.listCollections()
//                .forEach((Consumer<Document>) System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}