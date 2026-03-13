package lk.pdn.scs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        List<Course> activeProjects = new ArrayList<>();
        
      
        activeProjects.add(new Course(101, "Server Side Web Programming", "Dr. Perera"));
        
        
        request.setAttribute("courseList", activeProjects);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.html");
        dispatcher.forward(request, response);
    }
}