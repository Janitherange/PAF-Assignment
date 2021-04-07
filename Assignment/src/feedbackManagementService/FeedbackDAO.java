package feedbackManagementService;

import java.sql.*;

import connection.FeedbackConnection;

public class FeedbackDAO {

	public FeedbackDAO() {
			
	    }
	    
	FeedbackConnection orderConnection = new FeedbackConnection();
	    
	    public String readFeedback(){
	    	
			String output = "";
			
			try{
				Connection connect = orderConnection.getConnection();
				if (connect == null){
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table class='table table-bordered' style='border-color:#1A237E; overflow-x:auto;'>"
						+ "	   <thead>"
						+ "    		<tr>"
						+ "      		<th scope='col'>#</th>"
						+ "      		<th scope='col'>ID</th>"
						+ "				<th scope='col'>Title</th>"
						+ "				<th scope='col'>Rating</th>"
						+ "				<th scope='col'>Date</th>"
						+ "				<th scope='col'>Description</th>"
						+ "				<th scope='col'>Update</th>"
						+ "				<th scope='col'>Delete</th>"
						+ "			</tr>"
						+ "		</thead>";
				String query = "select * from `feedback`";
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				int i=0;
				
				// iterate through the rows in the result set
				while (rs.next()){
					i++;
					String hash = Integer.toString(i);
					String feedbackID = Integer.toString(rs.getInt("feedbackID"));
					String title = rs.getString("title");
					String rating = rs.getString("rating");
					String date = rs.getString("date");
					String description = rs.getString("description");
					
					// Add into the html table
					output += "<tr>";
					output += "<td scope='row'>" + hash + "</td>";
					output += "<td>" + feedbackID + "</td>";
					output += "<td>" + title + "</td>"; 
					output += "<td>" + rating + "</td>";
					output += "<td>" + date + "</td>";
					output += "<td>" + description + "</td>"; 
					// buttons
					output +="<form method='post' action='feedback-update.jsp'>"
							+ "<td>"
							+ "<input name='feedbackID' type='hidden' value='"+ feedbackID + "'>"
							+ "	  <button type='submit' class='btn operation-update' style='text-decoration: none;'>"
							+ "     <svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-arrow-clockwise operation-update' viewBox='0 0 16 16'>"
							+ "  		<path fill-rule='evenodd' d='M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z'/>"
							+ "  		<path d='M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z'/>"
							+ "		</svg>Update"
							+ "   </button>"
							+ "</td>"
							+ "</form>"
							+ "<form method='post' action='feedback-list.jsp'>"
							+ "<td>"
							+ "   <button type='submit' class='btn operation-delete' style='text-decoration: none;'>"
							+ "     <svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-x operation-delete' viewBox='0 0 16 16'>"
							+ "  		<path d='M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z'/>"
							+ "		</svg>Delete"
							+ "	  </button>"
							+ "</td>"
							+ " <input name='feedbackID' type='hidden' value='"+ feedbackID + "'>"
							+ "</form>"
							+ "</tr>"
							+ "</tbody>";
					}
					connect.close();
					// Complete the html table
					output += "</table>";
				}
				catch (Exception e){
					output = "Error while reading the items.";
					System.err.println(e.getMessage());
				}
			return output;
		}
	    
	    public String deleteFeedback(String feedbackID){
	    	
			String output = "";
			
			try{
				Connection connect = orderConnection.getConnection();
				if (connect == null){
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from `feedback` where feedbackID=?";
				PreparedStatement preparedStmt = connect.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(feedbackID));

				// execute the statement
				preparedStmt.execute();
				connect.close();
				output = "Deleted successfully";
			}
			catch (Exception e){
				output = "Error while deleting the item.";
				System.err.println(e.getMessage());
			}
			return output;
		}
}	    
