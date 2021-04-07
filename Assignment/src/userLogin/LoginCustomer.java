package userLogin;

import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import user.Customer;
import user.User;

@WebServlet("/loginCustomer")
public class LoginCustomer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginCustomer() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        
        Customer customer = new Customer();
         
        try {
            User user = customer.checkLogin(email, password);
            String destPage = request.getContextPath()+"/UserManagemnt/Customer/customer-sign-in.jsp";
             
            if (user != null) {
                session.setAttribute("user", user);
                destPage = request.getContextPath()+"/UserManagemnt/Customer/home-customer.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            response.sendRedirect(destPage);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
