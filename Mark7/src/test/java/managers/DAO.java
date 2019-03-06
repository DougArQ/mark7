package managers;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DAO {
	
	// Creating a Mongo client 
//	MongoClientURI uri = new MongoClientURI("mongodb://aluno:qaninja@ds225078.mlab.com:25078/heroku_4m3km28x");
//	MongoClient mongo = new MongoClient(uri);
	
	MongoClient mongo = new MongoClient( "ds225078.mlab.com" , 25078); 
	
    // Creating Credentials 
    MongoCredential credential = MongoCredential.createCredential("aluno", "heroku_4m3km28x", "qaninja".toCharArray()); 
	
	// Retrieving a collection
	MongoCollection<Document> collection = mongo.getDatabase("heroku_4m3km28x").getCollection("users");
	
	public DAO removerUsuario(String email) {
		collection.deleteOne(Filters.eq("email", email));
		System.out.println("Apagou "+email);
		return this;
	}
	
}
