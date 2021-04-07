package orderManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.OrderConnection;

@WebServlet("/updateOrder")
public class UpdateOrder extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public UpdateOrder() {
		 super();
	}
	
	OrderConnection orderConnection = new OrderConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		
		try{
			
			Connection connect = orderConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "UPDATE `order` SET name=?, quantity=?, date=?, status=? WHERE orderID="+orderID; 
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, request.getParameter("name"));
			preparedStmt.setInt(2, Integer.parseInt(request.getParameter("quantity")));
			preparedStmt.setString(3, request.getParameter("date"));
			preparedStmt.setString(4, request.getParameter("status"));
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("OrderManagement/order-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
