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


@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public UpdateProduct() {
		 
	}
	
	ProductConnection productConnection = new ProductConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
	@Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		int productID = Integer.parseInt(request.getParameter("productID"));
		
		try{
			
			Connection connect = productConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "UPDATE product SET name=?, price=?, category=?, stock=?, description=? WHERE productID="+productID; 
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, request.getParameter("name"));
			preparedStmt.setFloat(2, Float.parseFloat(request.getParameter("price")));
			preparedStmt.setString(3, request.getParameter("category"));
			preparedStmt.setInt(4, Integer.parseInt(request.getParameter("stock")));
			preparedStmt.setString(5, request.getParameter("description")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("ProductManagement/product-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
