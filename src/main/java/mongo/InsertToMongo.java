package mongo;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.SelectFormTable;
import org.json.JSONArray;
import java.util.*;

public class InsertToMongo<T> {

    public static void getInsertToMongo() {
        try (var mongoClient = MongoClients.create()) {

            var database = mongoClient.getDatabase("syn");
            database.createCollection("fromPostgres");

            MongoCollection<Document> fromPostgresColection = database.getCollection("fromPostgres");

            Map<String, String> map = new HashMap<>();

            /**>>>>>>>>> вставка <<<<<<<<<<<<*/
            Document fromPostgresDocument = new Document();
            for (JSONArray s : SelectFormTable.get_All_to_JSONArray()) {
                fromPostgresDocument = new Document(Map.of(
                        "_id", new ObjectId(),
                        "employe_id: ", s.get(0).toString(),
                        "first_name: ", s.get(1).toString(),
                        "last_name: ", s.get(2).toString(),
                        "email: ", s.get(3).toString(),
                        "phone_number: ", s.get(4).toString(),
                        "hire_date: ", s.get(5).toString(),
                        "job_id: ", s.get(6).toString(),
                        "salary: ", s.get(7).toString(),
                        "comission_pct: ", s.get(8).toString()
                ));
                fromPostgresColection.insertOne(fromPostgresDocument);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}