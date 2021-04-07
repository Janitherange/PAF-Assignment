package userUpdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.UserConnection;

@WebServlet("/updateCustomer")
public class UpdateCustomer extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public UpdateCustomer() {
		 
	}
	
	UserConnection userConnection = new UserConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
	@Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try{
			
			Connection connect = userConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "UPDATE customer SET email=?, password=?, name=?, dob=?, phone=?, address=? WHERE email='"+email+"' and password='"+password+"'"; 
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, request.getParameter("email"));
			preparedStmt.setString(2, request.getParameter("password"));
			preparedStmt.setString(3, request.getParameter("name"));
			preparedStmt.setString(4, request.getParameter("dob"));
			preparedStmt.setInt(5, Integer.parseInt(request.getParameter("phone"))); 
			preparedStmt.setString(6, request.getParameter("address"));
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("UserManagemnt/Customer/home-customer.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
