package feedbackManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.FeedbackConnection;

@WebServlet("/updateFeedback")
public class UpdateFeedback extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public UpdateFeedback() {
		 super();
	}
	
	FeedbackConnection orderConnection = new FeedbackConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
		
		try{
			
			Connection connect = orderConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "UPDATE `feedback` SET title=?, rating=?, date=?, description=? WHERE feedbackID="+feedbackID; 
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, request.getParameter("title"));
			preparedStmt.setString(2, request.getParameter("rating"));
			preparedStmt.setString(3, request.getParameter("date"));
			preparedStmt.setString(4, request.getParameter("description"));
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("FeedbackManagement/feedback-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
