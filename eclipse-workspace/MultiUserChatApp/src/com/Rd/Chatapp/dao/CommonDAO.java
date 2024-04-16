package com.Rd.Chatapp.dao;
 import java.sql.*;
 import static com.Rd.Chatapp.utils.ConfigReader.getValue;
public interface CommonDAO {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		//Load a Driver
		Class.forName(getValue("DRIVER"));
		// Making a Connection
		 final String CONNECTION_STRING=getValue("CONNECTION_URL");
		 final String USER_ID=getValue("USERID");
		 final String PASSWORD=getValue("PASSWORD");
		Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
		if(con!=null) {
			System.out.println("Connection Create....");
			
		}
		return con;
	}
	

}
