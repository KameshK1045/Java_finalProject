package classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database{

	public static Connection dbConnection;
	public static synchronized void getDBConnection() {
		if(dbConnection == null) {
			try {
				System.out.println("created");
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cricbuzz", "kamesh", "kamesh007");
			}catch(Exception ex) {
				System.out.println(ex.getMessage() + "1");
			
			}
		}
	}
	
	
}       

