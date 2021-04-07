package userLogout;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logoutCustomer")
public class LogoutCustomer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LogoutCustomer() {
        super();
    }
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.removeAttribute("user");
	             
	            response.sendRedirect(request.getContextPath()+"/UserManagemnt/Customer/customer-sign-in.jsp");
	        }
	    }
}
