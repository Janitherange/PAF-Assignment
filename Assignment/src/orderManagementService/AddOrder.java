package orderManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connection.OrderConnection;


@WebServlet("/addOrder")
public class AddOrder extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public AddOrder() {
		super();
	}
	
	OrderConnection orderConnection = new OrderConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		
		try{
			
			Connection connect = orderConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "insert into `order` (`orderID`,`name`,`quantity`,`date`,`status`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, request.getParameter("name"));
			preparedStmt.setInt(3, Integer.parseInt(request.getParameter("quantity")));
			preparedStmt.setString(4, request.getParameter("date"));
			preparedStmt.setString(5, request.getParameter("status")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("OrderManagement/order-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
