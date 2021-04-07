package userLogin;

import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import user.Administrator;
import user.User;

@WebServlet("/loginAdministrator")
public class LoginAdministrator extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginAdministrator() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession();
		
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        
        Administrator administator = new Administrator();
         
        try {
            User user = administator.checkLogin(email, password);
            String destPage = request.getContextPath()+"/UserManagemnt/Administrator/administrator-sign-in.jsp";
             
            if (user != null) {
                
                session.setAttribute("user", user);
                destPage = request.getContextPath()+"/UserManagemnt/Administrator/home-administrator.jsp";
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
