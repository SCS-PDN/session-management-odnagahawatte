package lk.pdn.scs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
    	String courseId = request.getParameter("courseId");
        
        HttpSession session = request.getSession();
        
        
        List<String> courseList = (List<String>) session.getAttribute("enrolledCourses");
        
        
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        
        
        if (courseId != null) {
            courseList.add(courseId);
        }
        
        
        session.setAttribute("enrolledCourses", courseList);
        
        
        response.sendRedirect("DashboardServlet?status=success");
    }
}