package lk.pdn.scs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        String userId = request.getParameter("username");
        String userPin = request.getParameter("password");

        
        if ("student1".equals(userId) && "pass1".equals(userPin)) {
            
            
            
            
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", userId);
            
            
            Cookie userCookie = new Cookie("username", userId);
            userCookie.setMaxAge(60 * 60);
            
            
            response.addCookie(userCookie);
            
            
            response.sendRedirect("DashboardServlet");
            
        } else {
            
            
            response.sendRedirect("index.html");
        }
    }
}