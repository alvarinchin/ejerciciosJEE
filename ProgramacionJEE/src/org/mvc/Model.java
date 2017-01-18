package org.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Model {
	
	protected Connection db;
	public Model(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user= "root";
			String schema = "libros";
			String pass="";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+schema, user,pass);
			this.db= con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
