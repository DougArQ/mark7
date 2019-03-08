package managers;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DAO {

//	private DBCollection collection;
//	private Mongo mongo;
//	private DB db;
//	private BasicDBObject document;

	private MongoClient mongo;
	private MongoDatabase db;
	private MongoCollection<Document> collection;

	public boolean conectar() {
		try {
//			// Creating a Mongo client
//			mongo = new Mongo("ds225078.mlab.com", 25078);
//
//			// Retrieving a collection
//			db = mongo.getDB("heroku_4m3km28x");
//			collection = db.getCollection("users");

			mongo = new MongoClient("ds225078.mlab.com", 25078);
			db = mongo.getDatabase("heroku_4m3km28x");
			collection = db.getCollection("users");

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public DAO removerUsuario(String email) {
//		document = new BasicDBObject();
//		document.remove("email", email);
////		collection.remove(document);
//		System.out.println("Apagou " + document);
		
		Bson filter = new Document("email", email);
		collection.deleteOne(filter);
		System.out.println("Apagou " + filter);
				
		return this;
	}

	public boolean desconectar() {
		try {
			mongo.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
