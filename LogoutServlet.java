package lk.pdn.scs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    
	    HttpSession session = request.getSession(false); 
	    if (session != null) {
	        session.invalidate(); 
	    }
	    
	    
	    Cookie deadCookie = new Cookie("username", ""); 
	    deadCookie.setMaxAge(0); 
	    response.addCookie(deadCookie);
	    
	    
	    response.sendRedirect("index.html");
	}
}