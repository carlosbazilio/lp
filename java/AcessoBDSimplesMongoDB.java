package br.uff.puro.ict.labides.projbd;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class AcessoBDSimplesMongoDB {
	
	public static void main(String[] args) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient();
			/* or
			mongoClient = new MongoClient( "localhost" );
			*/
			// or
			//mongoClient = new MongoClient( "localhost" , 27017 );
			// or, to connect to a replica set, supply a seed list of members
			/*mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
			                                      new ServerAddress("localhost", 27018),
			                                      new ServerAddress("localhost", 27019)));*/
			                                      
			DB db = mongoClient.getDB( "test" );			
			DBCollection coll = db.getCollection("test");
			
			/*
				{
				   "name" : "MongoDB",
				   "type" : "nosql database",
				   "count" : 1,
				   "info" : {
				               x : 203,
				               y : 102
				             }
				}
			 */

			System.out.println("Inicio da execução !!!");
			
			Timer tempo = new Timer();
			tempo.start();
			
			for (int i=0; i<1000000; i++) {
				BasicDBObject doc = new BasicDBObject("name", "MongoDB").
	                    append("type", "nosql database").
	                    append("count", 1).
	                    append("info", new BasicDBObject("x", 203).append("y", 102));

				coll.insert(doc);
			}

			tempo.end();
			
			System.out.println("Fim da execução !!!");
			
			System.out.println(tempo.getTotalTime());
			
			/*Set<String> colls = db.getCollectionNames();

			for (String s : colls) {
			    System.out.println(s);
			}*/
					
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();	
		}
	}
}
