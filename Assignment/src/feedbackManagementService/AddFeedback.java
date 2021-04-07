package feedbackManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connection.FeedbackConnection;


@WebServlet("/addFeedback")
public class AddFeedback extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public AddFeedback() {
		super();
	}
	
	FeedbackConnection feedbackConnection = new FeedbackConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		
		try{
			
			Connection connect = feedbackConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "insert into `feedback` (`feedbackID`,`title`,`rating`,`date`,`description`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, request.getParameter("title"));
			preparedStmt.setString(3, request.getParameter("rating"));
			preparedStmt.setString(4, request.getParameter("date"));
			preparedStmt.setString(5, request.getParameter("description")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("FeedbackManagement/feedback-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
