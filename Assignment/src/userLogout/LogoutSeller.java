package userLogout;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logoutSeller")
public class LogoutSeller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LogoutSeller() {
        super();
    }
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.removeAttribute("user");
	             
	            response.sendRedirect(request.getContextPath()+"/UserManagemnt/Seller/seller-sign-in.jsp");
	        }
	    }
}
