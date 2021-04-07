package productManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ProductConnection;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public AddProduct() {
		 
	}
	
	ProductConnection productConnection = new ProductConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
	@Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		
		try{
			
			Connection connect = productConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = " insert into product (`productID`,`name`,`price`,`category`,`stock`,`description`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, request.getParameter("name"));
			preparedStmt.setFloat(3, Float.parseFloat(request.getParameter("price")));
			preparedStmt.setString(4, request.getParameter("category"));
			preparedStmt.setInt(5, Integer.parseInt(request.getParameter("stock")));
			preparedStmt.setString(6, request.getParameter("description")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("ProductManagement/product-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
