package couponManagementService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.CouponConnection;

@WebServlet("/updateCoupon")
public class UpdateCoupon extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public UpdateCoupon() {
		 super();
	}
	
	CouponConnection couponConnection = new CouponConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		int couponID = Integer.parseInt(request.getParameter("couponID"));
		
		try{
			
			Connection connect = couponConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = "UPDATE `coupon` SET name=?, expireDate=?, saving=?, description=? WHERE couponID="+couponID; 
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, request.getParameter("name"));
			preparedStmt.setString(2, request.getParameter("expireDate"));
			preparedStmt.setString(3, request.getParameter("saving"));
			preparedStmt.setString(4, request.getParameter("description"));
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect("CouponManagement/coupon-list.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
