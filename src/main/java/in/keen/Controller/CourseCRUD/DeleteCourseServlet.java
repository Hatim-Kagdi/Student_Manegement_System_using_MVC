package in.keen.Controller.CourseCRUD;

import java.io.IOException;

import in.keen.DAO.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCourse")
public class DeleteCourseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("courseId"));
		
		CourseDAO dao = new CourseDAO();
		
		boolean status = dao.deleteCourse(id);
		
		if(status) {
			resp.sendRedirect("viewCourses");
		}else {
			resp.getWriter().print("Delete failed!");
		}
	}
}
