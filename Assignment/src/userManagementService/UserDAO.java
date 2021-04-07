package userManagementService;

import java.sql.*;

import connection.UserConnection;

public class UserDAO {

	public UserDAO() {
			
	    }
	    
		UserConnection userConnection = new UserConnection();
	    
	    public String readSellers(){
	    	
			String output = "";
			
			try{
				Connection connect = userConnection.getConnection();
				if (connect == null){
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table class='table table-bordered' style='border-color:#1A237E; overflow-x:auto;'>"
						+ "	   <thead>"
						+ "    		<tr>"
						+ "      		<th scope='col'>#</th>"
						+ "      		<th scope='col'>ID</th>"
						+ "				<th scope='col'>Name</th>"
						+ "				<th scope='col'>Phone</th>"
						+ "				<th scope='col'>Email</th>"
						+ "				<th scope='col'>Dob</th>"
						+ "				<th scope='col'>Address</th>"
						+ "				<th scope='col'>Update</th>"
						+ "				<th scope='col'>Delete</th>"
						+ "			</tr>"
						+ "		</thead>";
				String query = "select * from `seller`";
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				int i=0;
				
				// iterate through the rows in the result set
				while (rs.next()){
					i++;
					String hash = Integer.toString(i);
					String sellerID = Integer.toString(rs.getInt("sellerID"));
					String name = rs.getString("name");
					String phone = Integer.toString(rs.getInt("phone"));
					String email = rs.getString("email");
					String dob = rs.getString("dob");
					String address = rs.getString("address");
					
					// Add into the html table
					output += "<tr>";
					output += "<td scope='row'>" + hash + "</td>";
					output += "<td>" + sellerID + "</td>";
					output += "<td>" + name + "</td>"; 
					output += "<td>" + phone + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + dob + "</td>"; 
					output += "<td>" + address + "</td>"; 
					// buttons
					output +="<form method='post' action='seller-update.jsp'>"
							+ "<td>"
							+ "<input name='sellerID' type='hidden' value='"+ sellerID + "'>"
							+ "	  <button type='submit' class='btn operation-update' style='text-decoration: none;'>"
							+ "     <svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-arrow-clockwise operation-update' viewBox='0 0 16 16'>"
							+ "  		<path fill-rule='evenodd' d='M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z'/>"
							+ "  		<path d='M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z'/>"
							+ "		</svg>Update"
							+ "   </button>"
							+ "</td>"
							+ "</form>"
							+ "<form method='post' action='seller-list.jsp'>"
							+ "<td>"
							+ "   <button type='submit' class='btn operation-delete' style='text-decoration: none;'>"
							+ "     <svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-x operation-delete' viewBox='0 0 16 16'>"
							+ "  		<path d='M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z'/>"
							+ "		</svg>Delete"
							+ "	  </button>"
							+ "</td>"
							+ " <input name='sellerID' type='hidden' value='"+ sellerID + "'>"
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
	    
	    public String deleteSeller(String sellerID){
	    	
			String output = "";
			
			try{
				Connection connect = userConnection.getConnection();
				if (connect == null){
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from seller where sellerID=?";
				PreparedStatement preparedStmt = connect.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(sellerID));

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
	    
	    public String readCustomers(){
	    	
			String output = "";
			
			try{
				Connection connect = userConnection.getConnection();
				if (connect == null){
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table class='table table-bordered' style='border-color:#1A237E; overflow-x:auto;'>"
						+ "	   <thead>"
						+ "    		<tr>"
						+ "      		<th scope='col'>#</th>"
						+ "      		<th scope='col'>ID</th>"
						+ "				<th scope='col'>Name</th>"
						+ "				<th scope='col'>Phone</th>"
						+ "				<th scope='col'>Email</th>"
						+ "				<th scope='col'>Dob</th>"
						+ "				<th scope='col'>Address</th>"
						+ "				<th scope='col'>Update</th>"
						+ "				<th scope='col'>Delete</th>"
						+ "			</tr>"
						+ "		</thead>";
				String query = "select * from `customer`";
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				int i=0;
				
				// iterate through the rows in the result set
				while (rs.next()){
					i++;
					String hash = Integer.toString(i);
					String customerID = Integer.toString(rs.getInt("customerID"));
					String name = rs.getString("name");
					String phone = Integer.toString(rs.getInt("phone"));
					String email = rs.getString("email");
					String dob = rs.getString("dob");
					String address = rs.getString("address");
					
					// Add into the html table
					output += "<tr>";
					output += "<td scope='row'>" + hash + "</td>";
					output += "<td>" + customerID + "</td>";
					output += "<td>" + name + "</td>"; 
					output += "<td>" + phone + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + dob + "</td>"; 
					output += "<td>" + address + "</td>"; 
					// buttons
					output +="<form method='post' action='customer-update.jsp'>"
							+ "<td>"
							+ "<input name='customerID' type='hidden' value='"+ customerID + "'>"
							+ "	  <button type='submit' class='btn operation-update' style='text-decoration: none;'>"
							+ "     <svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-arrow-clockwise operation-update' viewBox='0 0 16 16'>"
							+ "  		<path fill-rule='evenodd' d='M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z'/>"
							+ "  		<path d='M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z'/>"
							+ "		</svg>Update"
							+ "   </button>"
							+ "</td>"
							+ "</form>"
							+ "<form method='post' action='customer-list.jsp'>"
							+ "<td>"
							+ "   <button type='submit' class='btn operation-delete' style='text-decoration: none;'>"
							+ "     <svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-x operation-delete' viewBox='0 0 16 16'>"
							+ "  		<path d='M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z'/>"
							+ "		</svg>Delete"
							+ "	  </button>"
							+ "</td>"
							+ " <input name='customerID' type='hidden' value='"+ customerID + "'>"
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
	    
	    public String deleteCustomer(String customerID){
	    	
			String output = "";
			
			try{
				Connection connect = userConnection.getConnection();
				if (connect == null){
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from customer where customerID=?";
				PreparedStatement preparedStmt = connect.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(customerID));

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
