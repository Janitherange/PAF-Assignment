package userManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.UserConnection;


@WebServlet("/updateSellerByAdmin")
public class UpdateSeller extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public UpdateSeller() {
		 
	}
	
	UserConnection userConnection = new UserConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
	@Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		int sellerID = Integer.parseInt(request.getParameter("sellerID"));
		
		try{
			
			Connection connect = userConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "UPDATE seller SET email=?, password=?, name=?, dob=?, phone=?, address=? WHERE sellerID="+sellerID; 
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, request.getParameter("email"));
			preparedStmt.setFloat(2, Float.parseFloat(request.getParameter("password")));
			preparedStmt.setString(3, request.getParameter("name"));
			preparedStmt.setString(4, request.getParameter("dob"));
			preparedStmt.setInt(5, Integer.parseInt(request.getParameter("phone")));
			preparedStmt.setString(6, request.getParameter("address")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("UserManagemnt/userCrud/seller-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
