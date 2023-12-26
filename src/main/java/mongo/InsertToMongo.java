package mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.SelectFormTable;
import org.json.JSONArray;

import java.util.Map;

import static org.example.SelectFormTable.get_All_to_JSONArray;

public class InsertToMongo<T> {
    public static void main(String[] args) {

        try (var mongoClient = MongoClients.create()) {
//        mongoClient.listDatabases();
//        mongoClient.listDatabaseNames()
//                .forEach((Consumer<String>) System.out::println);

          /*  var database = mongoClient.getDatabase("syn");
            database.createCollection("fromPostgres");

            MongoCollection<Document> fromPostgresColection = database.getCollection("fromPostgres");
*/
//            var todoDocment = new Document(Map.of(
//                    "_id", new ObjectId(),
//                    "task", "Drynk some coffee",
//                    "dataCreated", LocalDateTime.now(),
//                    "done", false));

            for (int i = 0; i < SelectFormTable.get_All_to_JSONArray().size(); i++) {

            }


//        database.listCollectionNames()
//                .forEach((Consumer<String>) System.out::println);
//        database.listCollections()
//                .forEach((Consumer<Document>) System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}