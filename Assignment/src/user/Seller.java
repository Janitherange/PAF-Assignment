package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.UserConnection;

public class Seller {

	UserConnection sellerConnection = new UserConnection();
	
	
	public User checkLogin (String email, String password) throws SQLException,
    ClassNotFoundException {
		
		User user = null;
		
		try{
			
			Connection connect = sellerConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String sql = "SELECT email, password FROM seller WHERE email = ? and password = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, email);
		    statement.setString(2, password);
			
	        ResultSet result = statement.executeQuery();
	       
	        if (result.next()) {

	            user = new User();
	            user.setEmail(email);
	            user.setPassword(password);
	            
	        }
	       
	        connect.close();
	 
		}catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}
}
