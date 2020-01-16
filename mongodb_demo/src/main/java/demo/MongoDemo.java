package demo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwb on 2019/12/02.
 * MongoDB入门Demo
 */
public class MongoDemo {
	public static void main(String[] args) {
		//创建连接
		MongoClient client = new MongoClient("127.0.0.1");
		//打开数据库
		MongoDatabase spitdb = client.getDatabase("spitdb");
		//获取集合
		MongoCollection<Document> spit = spitdb.getCollection("spit");
		//构建查询条件 userid=1013
//		BasicDBObject bson = new BasicDBObject("userid", "1013");
		//构建查询条件 visits > 1000
		BasicDBObject bson = new BasicDBObject("visits", new BasicDBObject("$lt", 1000));
		//查找记录获取文档集合
		FindIterable<Document> documents = spit.find(bson);
		for (Document document : documents) {
			System.out.println("用户ID: " + document.getString("userid"));
			System.out.println("内容："+document.getString("content"));
			System.out.println("visits: " + document.getInteger("visits"));
			System.out.println();
		}
		Map<String, Object> map = new HashMap<>(16);
		map.put("userid", "9999");
		map.put("content", "hahaha");
		map.put("visits", 100);
		Document document = new Document(map);
		// 插入新文档
		spit.insertOne(document);
		client.close();
	}
}
