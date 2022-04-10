import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void testMongo(){
        List<ServerAddress> adds = new ArrayList<>();
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);
        adds.add(serverAddress);

        List<MongoCredential> credentials = new ArrayList<>();

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("root", "test", "123456".toCharArray());
        credentials.add(mongoCredential);

        MongoClient mongoClient = new MongoClient(adds, credentials);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        Document document = new Document("name","张三")
                .append("sex", "男")
                .append("age", 19);
        //插入一个文档
        collection.insertOne(document);

        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        mongoClient.close();
    }
}
