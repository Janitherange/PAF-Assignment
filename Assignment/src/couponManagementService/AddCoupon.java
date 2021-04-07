package couponManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connection.CouponConnection;


@WebServlet("/addCoupon")
public class AddCoupon extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public AddCoupon() {
		super();
	}
	
	CouponConnection couponConnection = new CouponConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		
		try{
			
			Connection connect = couponConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "insert into `coupon` (`couponID`,`name`,`expireDate`,`saving`,`description`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, request.getParameter("name"));
			preparedStmt.setString(3, request.getParameter("expireDate"));
			preparedStmt.setString(4, request.getParameter("saving"));
			preparedStmt.setString(5, request.getParameter("description")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("CouponManagement/coupon-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
